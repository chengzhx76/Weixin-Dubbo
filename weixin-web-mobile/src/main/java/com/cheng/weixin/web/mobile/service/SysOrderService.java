package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.common.utils.StringUtils;
import com.cheng.weixin.common.utils.SystemUtils;
import com.cheng.weixin.rpc.cart.model.ProductModel;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.rpc.order.entity.*;
import com.cheng.weixin.rpc.order.enumType.OrderType;
import com.cheng.weixin.rpc.order.enumType.PayStatus;
import com.cheng.weixin.rpc.order.enumType.PayWay;
import com.cheng.weixin.rpc.order.service.RpcOrderService;
import com.cheng.weixin.rpc.promotion.entity.CouponCode;
import com.cheng.weixin.rpc.promotion.enums.CouponType;
import com.cheng.weixin.rpc.promotion.service.RpcCouponService;
import com.cheng.weixin.rpc.user.entity.*;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import com.cheng.weixin.web.mobile.exception.BusinessException;
import com.cheng.weixin.web.mobile.exception.OrderException;
import com.cheng.weixin.web.mobile.exception.message.StatusCode;
import com.cheng.weixin.web.mobile.param.PaymentDto;
import com.cheng.weixin.web.mobile.result.order.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/9/14
 */
@Service("sysOrderService")
public class SysOrderService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RpcUserService userService;
    @Autowired
    private RpcOrderService orderService;
    @Autowired
    private RpcCartService cartService;
    @Autowired
    private RpcProductService productService;
    @Autowired
    private RpcCouponService couponService;

    public SubmitOrderInfo payment(PaymentDto payment) {

        SubmitOrderInfo submitOrder = new SubmitOrderInfo();
        if (payment!=null && payment.getAddrId() != null && !"".equals(payment.getAddrId())) {
            if (payment.getSince()) {
                ArayacakAddress arayacakAddress = orderService.getArayacakAddressById(payment.getAddrId());
                Member member = userService.getMemberById("1");
                submitOrder.setMobile(member.getMobile());
                submitOrder.setAddress(arayacakAddress.getAddress());
                submitOrder.setSince(true);
            }else {
                DeliveryAddress addr = userService.getDeliveryAddress(payment.getAddrId(), "1");
                submitOrder.setConsignee(addr.getConsignee());
                submitOrder.setMobile(addr.getMobile());
                submitOrder.setAddress(addr.getAddress());
                submitOrder.setSince(false);
            }
            submitOrder.setAddrId(payment.getAddrId());
        }else {
            DeliveryAddress addr = userService.getDefaultAddress("1");
            submitOrder.setConsignee(addr.getConsignee());
            submitOrder.setMobile(addr.getMobile());
            submitOrder.setAddress(addr.getAddress());
            submitOrder.setAddrId(addr.getId());
            submitOrder.setSince(false);
        }

        // 配送时间
        List<DeliveryTime> times = orderService.getAllDeliveryTimes();
        List<OrderDeliveryTime> orderDeliveryTimes = new ArrayList<>();
        for (DeliveryTime deliveryTime : times) {
            orderDeliveryTimes.add(new OrderDeliveryTime(deliveryTime.getId(), deliveryTime.getName()));
        }
        submitOrder.setDeliveryTimes(orderDeliveryTimes);

        // 支付方式
        List<Pay> pays = orderService.getAllPay();
        List<OrderPay> orderPays = new ArrayList<>();
        for (Pay pay : pays) {
            if (pay.getRecommend()) {
                submitOrder.setRecPay(new OrderPay(pay.getId(), pay.getName(), pay.getIcon()));
            }else {
                orderPays.add(new OrderPay(pay.getId(), pay.getName(), pay.getIcon()));
            }
        }
        submitOrder.setPays(orderPays);

        // 余额
        Account account = userService.getAccount("1");
        submitOrder.setAvailableBalance(StringFormat.format(account.getBalance()));

        // 商品详情
        int totalProductNums = 0;
        BigDecimal totalProductPrice = BigDecimal.ZERO;
        Set<String> productIds = cartService.getChooseProductIds("1");
        //String[] productImgs = new String[productIds.size()];
        List<String> productImgs = new ArrayList<>(productIds.size());
        //for (int i=0; i<productIds.size(); i++) {
        for (String productId : productIds) {
            Product product = productService.getDefaultPictureById(productId);
            if (product.getUnitsInStock() > 0) {
                Long productNums = cartService.getCounts("1", productId);
                totalProductNums += productNums;
                totalProductPrice = totalProductPrice.add(product.getSalePrice().multiply(BigDecimal.valueOf(productNums)));
                productImgs.add(product.getDefaultPicture().getPictureUrl());
            }
        }
        submitOrder.setTotalProductNums(totalProductNums);
        submitOrder.setProductImgs(productImgs);
        submitOrder.setTotalProductPrice(StringFormat.format(totalProductPrice));

        // 优惠券
        List<CouponCode> couponCodes = couponService.getCouponCodeByUser("1");
        int availableCoupon = 0;
        for (CouponCode code : couponCodes) {
            // 只有红包券才是满减券
            if (CouponType.LUCKYMONEY.equals(code.getCoupon().getType())) {
                if (totalProductPrice.compareTo(code.getCoupon().getEnoughMoney()) == 0
                        || totalProductPrice.compareTo(code.getCoupon().getEnoughMoney()) == 1) {
                    availableCoupon += 1;
                }
            }/* else {
                // 是否包含该商品ID
                if (code.getCoupon().getIncludeGroup()!=null && !"".equals(code.getCoupon().getIncludeGroup())) {
                    List<String> includeIds = Arrays.asList(StringUtils.split(code.getCoupon().getIncludeGroup(), ","));
                    for (String id : productIds) {
                        if (includeIds.contains(id)) {
                            availableCoupon += 1;
                        }
                    }
                }
                boolean notContain = true;
                if (code.getCoupon().getExcludeGroup()!=null && !"".equals(code.getCoupon().getExcludeGroup())) {
                    List<String> notIncludeIds = Arrays.asList(code.getCoupon().getExcludeGroup().split(","));
                    for (String id : productIds) {
                        if (notIncludeIds.contains(id)) {
                            notContain = false;
                        }
                    }
                }
                if (notContain) {
                    availableCoupon += 1;
                }
            }*/
        }
        submitOrder.setAvailableCoupon(availableCoupon);

        // 运费
        BigDecimal freight = BigDecimal.valueOf(2.00);
        if (totalProductPrice.compareTo(BigDecimal.valueOf(5))==0 || totalProductPrice.compareTo(BigDecimal.valueOf(5))==1) {
            freight = BigDecimal.ZERO;
        }
        submitOrder.setFreight(StringFormat.format(freight));

        // 优惠券
        BigDecimal couponReducePrice = BigDecimal.ZERO;
        if (payment != null && payment.getTicketId() !=null && !"".equals(payment.getTicketId())) {
            CouponCode couponCode;
            try {
                couponCode = couponService.getCouponById(payment.getTicketId());
            }catch (Exception e) {
                logger.error("优惠券不正确");
                throw new OrderException(StatusCode.COUPON_EXCEPTION);
            }
            couponReducePrice = couponCode.getCoupon().getFaceValue();
        }
        submitOrder.setCouponRecord(StringFormat.format(couponReducePrice));

        // 总得价格
        submitOrder.setTotalPrice(StringFormat.format(totalProductPrice.add(freight).subtract(couponReducePrice)));
        return submitOrder;
    }

    /** 购买商品列表 **/
    public List<ProductList> getProductList() {
        List<ProductModel> productModels = cartService.getChooseProductInfo("1");
        List<ProductList> productLists = new ArrayList<>();
        for (ProductModel model : productModels) {
            ProductList productList = new ProductList();
            Product product = productService.getDefaultPictureById(model.getId());
            productList.setName(product.getName());
            productList.setImgUrl(product.getDefaultPicture().getPictureUrl());
            productList.setCount(model.getCount());
            productList.setDesc(product.getUnitDesc());
            productList.setSellPrice(StringFormat.format(product.getSalePrice()));
            productLists.add(productList);
        }
        return productLists;
    }

    public void buy(PaymentDto payment, HttpServletRequest request) {

        BigDecimal totalProductPrice = new BigDecimal(0);
        List<ProductModel> productModels = cartService.getChooseProductInfo("1");
        for (int i=0; i<productModels.size(); i++) {
            Product product = productService.getById(productModels.get(i).getId());
            int counts = productModels.get(i).getCount();
            totalProductPrice = totalProductPrice.add(product.getSalePrice().multiply(BigDecimal.valueOf(counts)));
            productService.updateStockById(product.getId(), product.getUnitsInStock()-counts, false);
        }
        cartService.deletedChooseProduct("1");

        // 生成订单
        OrderInfo order = new OrderInfo();
        String oid = RandomStringUtils.randomNumeric(8); //TODO
        order.setOid(oid);
        order.setAccountId("1");
        // 配送地址
        if (payment!=null && payment.getAddrId() != null && !"".equals(payment.getAddrId())) {
            if (payment.getSince()) {
                ArayacakAddress arayacakAddress = orderService.getArayacakAddressById(payment.getAddrId());
                Member member = userService.getMemberById("1");
                order.setMobile(member.getMobile());
                order.setAddress(arayacakAddress.getAddress());
                order.setSince(true);
            }else {
                DeliveryAddress addr = userService.getDeliveryAddress(payment.getAddrId(), "1");
                order.setMobile(addr.getMobile());
                order.setVillageId(addr.getVillageId());
                order.setAddress(addr.getAddress());
                order.setPostCode(addr.getPostCode());
                order.setTelephone(addr.getTelephone());
                order.setEmail(addr.getEmail());
                order.setSince(false);
            }
        }else {
            DeliveryAddress addr = userService.getDefaultAddress("1");
            order.setConsignee(addr.getConsignee());
            order.setMobile(addr.getMobile());
            order.setVillageId(addr.getVillageId());
            order.setAddress(addr.getAddress());
            order.setPostCode(addr.getPostCode());
            order.setTelephone(addr.getTelephone());
            order.setEmail(addr.getEmail());
            order.setSince(false);
        }
        String payId;
        if (payment !=null && payment.getPayId()!=null && !"".equals(payment.getPayId())) {
            payId = payment.getPayId();
        }else {
            Pay pay = orderService.getRecommendPay();
            payId = pay.getId();
        }
        Pay pay = orderService.getPay(payId);
        if (PayWay.ONLINE.equals(pay.getPayWay())) {
            order.setPayStatus(PayStatus.NONPAYMENT);
            List<FlowStatus> statuses = orderService.getFlowStatusesByPayWay(PayWay.ONLINE);
            order.setFlowStatus(statuses.get(0).getId());
        } else if (PayWay.OFFLINE.equals(pay.getPayWay())) {
            order.setPayStatus(PayStatus.FREIGHTCOLLECT);
            List<FlowStatus> statuses = orderService.getFlowStatusesByPayWay(PayWay.OFFLINE);
            order.setFlowStatus(statuses.get(0).getId());
        }

        DeliveryTime time = orderService.getDeliveryTime(payment.getTimeId());
        order.setDeliveryTime(time.getName());
        order.setPay(pay.getName());
        order.setOrderType(OrderType.NORMAL);

        // 计算运费
        if (totalProductPrice.compareTo(BigDecimal.valueOf(5L))==1 || totalProductPrice.compareTo(BigDecimal.valueOf(5L)) == 0) {
            order.setFreightPayable(BigDecimal.ZERO);
            order.setFreightReduce(BigDecimal.valueOf(2L));
        } else {
            order.setFreightPayable(BigDecimal.valueOf(2L)); // 应付运费
            order.setFreightReduce(BigDecimal.ZERO); // 运费优惠
        }

        Account account = userService.getAccount("1");
        // 是否是用余额支付
        if(payment.getBalance()) {
            BigDecimal balance = null;
            BigDecimal totalPrice = totalProductPrice.add(order.getFreightPayable());
            if (account.getBalance().compareTo(totalPrice) == 1 || account.getBalance().compareTo(totalPrice) == 0) {
                balance = account.getBalance().subtract(totalPrice);
                order.setBalanceOffset(totalPrice);
            }else if (account.getBalance().compareTo(totalPrice) == -1) {
                order.setBalanceOffset(account.getBalance());
                balance = BigDecimal.ZERO;
            }
            account.setBalance(balance);
        }
        userService.updateAccount(account);

        order.setProductTotalPrice(totalProductPrice); // 商品总金额
        order.setDiscount(BigDecimal.ZERO); // 优惠金额

        // 券优惠
        BigDecimal couponReducePrice = BigDecimal.ZERO;
        if (payment.getTicketId()!=null && !"".equals(payment.getTicketId())) {
            CouponCode couponCode;
            try {
                couponCode = couponService.getCouponById(payment.getTicketId());
            }catch (Exception e) {
                logger.error("优惠券不正确");
                throw new OrderException(StatusCode.COUPON_EXCEPTION);
            }
            couponReducePrice = couponCode.getCoupon().getFaceValue();
            order.setCouponCode(couponCode.getCode());

            // 优惠券记录
            CouponRecord couponRecord = new CouponRecord();
            couponRecord.setAccountId("1");
            couponRecord.setCouponCodeId(couponCode.getId());
            couponRecord.setTxType("支出");
            couponRecord.setTxResult("消费一张优惠券金额为"+ StringFormat.format(couponCode.getCoupon().getFaceValue()));
            userService.addCouponRecord(couponRecord);
            couponService.updateCouponUsedById(couponCode.getId());
        }
        order.setCouponReducePrice(couponReducePrice);

        order.setBonusPointReducePrice(BigDecimal.ZERO); // 积分优惠

        // 应付金额 = 应付运费 - 运费优惠 + 商品总金额 - 优惠金额 - 券优惠 - 积分优惠
        order.setAmountPayable(order.getFreightPayable().subtract(order.getFreightReduce()).add(totalProductPrice)
                .subtract(order.getDiscount()).subtract(order.getCouponReducePrice()).subtract(order.getBonusPointReducePrice()));
        // 已付金额 = 应付运费 - 运费优惠 + 商品总金额 - 优惠金额 - 券优惠 - 积分优惠 - 余额抵扣
        BigDecimal amountPaid = order.getFreightPayable().subtract(order.getFreightReduce()).add(totalProductPrice)
                                .subtract(order.getDiscount()).subtract(order.getCouponReducePrice()).subtract(order.getBonusPointReducePrice());
        if (payment.getBalance()) { // 是否是用余额支付
            amountPaid = amountPaid.subtract(order.getBalanceOffset());
        }
        order.setAmountPaid(amountPaid);

        order.setRemarkCustomer(payment.getRemark());
        order.setIp(SystemUtils.getRemoteAddr(request));
        order.setPayTime(new Date());
        order.setFreeAccountLevel(Boolean.FALSE);
        orderService.addOrder(order);

        // 积分记录
        BonusPointRecord bonusPoint = userService.getBonusPointRecord("1");
        BonusPointRecord bonusPointRecord = new BonusPointRecord();
        bonusPointRecord.setTxBonusPoints(10);// TODO 本次订单获取的积分
        bonusPointRecord.setFrozenBonusPoints(10);
        if (bonusPoint != null) {
            bonusPointRecord.setBeforeBonusPoints(bonusPoint.getAfterBonusPoints());
            bonusPointRecord.setAfterBonusPoints(bonusPoint.getAfterBonusPoints()+10);
        }else {
            bonusPointRecord.setBeforeBonusPoints(0);
            bonusPointRecord.setAfterBonusPoints(10);
        }
        bonusPointRecord.setTxResult("下单获取10积分");
        userService.addBonusPointRecord(bonusPointRecord);

        // 现金记录
        if (payment.getBalance()) {
            CashRecord cash = userService.getNewCashRecord("1");
            if (cash == null) {
                throw new BusinessException("请先充值");
            }

            CashRecord cashRecord = new CashRecord();
            cashRecord.setAccountId("1");
            cashRecord.setTxMoney(order.getBalanceOffset());
            cashRecord.setBeforeMoney(cash.getAfterBonusPoints());
            BigDecimal afterBonusPoints = cash.getAfterBonusPoints().subtract(order.getBalanceOffset());
            if (afterBonusPoints.compareTo(BigDecimal.valueOf(-1L)) == -1) {
                throw new BusinessException("余额不足");
            }
            cashRecord.setAfterBonusPoints(afterBonusPoints);
            cashRecord.setTxType("支出");
            cashRecord.setTxResult("结果");
            userService.addCashRecord(cashRecord);
        }
    }


    public List<OrderList> getOrders() {
        List<OrderInfo> orderInfos = orderService.getOrderInfos("1");
        List<OrderList> orders = new ArrayList<>();
        for (OrderInfo order : orderInfos) {
            OrderList orderList = new OrderList();
            orderList.setId(order.getId());
            orderList.setDate(new DateTime(order.getCreateDate()).toString("dd-MM-yyyy HH:mm:ss"));
            orderList.setOrderNum(order.getOid());
            orderList.setNumber(order.getOrderDetails().size()+"");
            orderList.setStatus(order.getFlowStatus().split("-"));
            // 总金额 = 商品总金额 - 余额抵扣 - 优惠金额 + 应付运费
            //orderList.setTotalPrice(StringFormat.format(
            //        order.getProductTotalPrice().subtract(order.getBalanceOffset())
            //        .subtract(order.getDiscount()).add(order.getFreightPayable())));

            orderList.setTotalPrice(StringFormat.format(order.getAmountPayable()));
            String orderStatus = "";
            if (PayStatus.NONPAYMENT.equals(order.getPayStatus())) {
                orderStatus = "INVALID";
            } else if (StringUtils.isBlank(order.getCommentId())) {
                orderStatus = "WAITCOMMENT";
                orderList.setCommentId(order.getCommentId());
            }
            orderList.setOrderStatus(orderStatus);
            orders.add(orderList);
        }
        return orders;
    }

    public OrderDetail getOrderDetail() {
        OrderDetail detail = new OrderDetail();
        OrderInfo orderInfo = orderService.getOrderDetail("1700b55803cc44dfa08bac0028bee46f");
        detail.setId(orderInfo.getId());
        String[] flowStatus = orderInfo.getFlowStatus().split("-");
        detail.setStatus(flowStatus[flowStatus.length-1]);
        detail.setOid(orderInfo.getOid());
        detail.setConsignee(orderInfo.getConsignee());
        detail.setAddress(orderInfo.getAddress());

        Pay pay = orderService.getPay(orderInfo.getPay());

        detail.setPayWay(pay.getName());
        detail.setProductTotalPrice(StringFormat.format(orderInfo.getProductTotalPrice()));
        detail.setFreightPayable(StringFormat.format(orderInfo.getFreightPayable()));
        detail.setCouponReducePrice(StringFormat.format(orderInfo.getCouponReducePrice()));
        detail.setBalanceOffset(StringFormat.format(orderInfo.getBalanceOffset()));
        // 总金额 = 商品总金额 - 余额抵扣 - 优惠金额 + 应付运费
        //detail.setTotalPrice(StringFormat.format(
        //        orderInfo.getProductTotalPrice().subtract(orderInfo.getBalanceOffset())
        //        .subtract(orderInfo.getDiscount()).add(orderInfo.getFreightPayable())));
        detail.setTotalPrice(StringFormat.format(orderInfo.getAmountPayable()));
        String orderStatus = "";
        if (orderInfo.getPayStatus().equals(PayStatus.NONPAYMENT)) {
            orderStatus = "INVALID";
        } else if (StringUtils.isBlank(orderInfo.getCommentId())) {
            orderStatus = "WAITCOMMENT";
            detail.setCommentId(orderInfo.getCommentId());
        }
        detail.setOrderStatus(orderStatus);
        return detail;
    }

    public List<ArayacakTownAddr> getAllTownArayacakAddr(String countryId) {
        List<ArayacakAddress> countyAddrs = orderService.getArayacakAddr(countryId, null);

        Set<String> townIds = new HashSet<>();
        for (ArayacakAddress addr : countyAddrs) {
            townIds.add(addr.getTown());
        }
        List<ArayacakTownAddr> townAddrs = new ArrayList<>();
        for (String townId: townIds) {
            Town town = orderService.getTownById(townId);
            townAddrs.add(new ArayacakTownAddr(townId, town.getName()));
        }
        return townAddrs;
    }

    public List<ArayacakVillageAddr> getAllVillageArayacakAddr(String townId) {
        List<ArayacakAddress> villageAllAddrs = orderService.getArayacakAddr(null, townId);
        List<ArayacakVillageAddr> villageAddrs = new ArrayList<>();
        for (ArayacakAddress addr: villageAllAddrs) {
            villageAddrs.add(new ArayacakVillageAddr(addr.getId(), addr.getAddress(), "3.2"));
        }
        return villageAddrs;
    }
}
