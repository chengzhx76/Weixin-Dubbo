package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.model.Page;
import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.common.utils.SystemUtils;
import com.cheng.weixin.rabbitmq.enums.MsgType;
import com.cheng.weixin.rabbitmq.model.SmsModel;
import com.cheng.weixin.rpc.cart.model.ProductModel;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.rpc.order.entity.*;
import com.cheng.weixin.rpc.order.enumType.OrderStatus;
import com.cheng.weixin.rpc.order.enumType.OrderType;
import com.cheng.weixin.rpc.order.enumType.PayWay;
import com.cheng.weixin.rpc.order.service.RpcOrderService;
import com.cheng.weixin.rpc.promotion.entity.CouponCode;
import com.cheng.weixin.rpc.promotion.enums.CouponType;
import com.cheng.weixin.rpc.promotion.service.RpcCouponService;
import com.cheng.weixin.rpc.rabbitmq.service.RpcRabbitSmsService;
import com.cheng.weixin.rpc.user.entity.*;
import com.cheng.weixin.rpc.user.enumType.TXType;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import com.cheng.weixin.web.mobile.exception.BusinessException;
import com.cheng.weixin.web.mobile.exception.OrderException;
import com.cheng.weixin.web.mobile.exception.message.StatusCode;
import com.cheng.weixin.web.mobile.param.PaymentDto;
import com.cheng.weixin.web.mobile.result.order.*;
import com.cheng.weixin.web.mobile.security.LocalUser;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
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
    @Autowired
    private RpcRabbitSmsService rabbitService;

    public SubmitOrderInfo payment(PaymentDto payment) {

        SubmitOrderInfo submitOrder = new SubmitOrderInfo();
        if (payment!=null && payment.getAddrId() != null && !"".equals(payment.getAddrId())) {
            if (payment.getSince()) {
                ArayacakAddress arayacakAddress = orderService.getArayacakAddressById(payment.getAddrId());
                Member member = userService.getMemberByAccountId(LocalUser.getUser().getUserId());
                submitOrder.setMobile(member.getMobile());
                submitOrder.setAddress(arayacakAddress.getAddress());
                submitOrder.setSince(true);
            }else {
                DeliveryAddress addr = userService.getDeliveryAddress(payment.getAddrId(), LocalUser.getUser().getUserId());
                submitOrder.setConsignee(addr.getConsignee());
                submitOrder.setMobile(addr.getMobile());
                submitOrder.setAddress(addr.getAddress());
                submitOrder.setSince(false);
            }
            submitOrder.setAddrId(payment.getAddrId());
        }else {
            DeliveryAddress addr = userService.getDefaultAddress(LocalUser.getUser().getUserId());
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
        Account account = userService.getAccount(LocalUser.getUser().getUserId());
        submitOrder.setAvailableBalance(StringFormat.format(account.getBalance()));

        // 商品详情
        int totalProductNums = 0;
        BigDecimal totalProductPrice = BigDecimal.ZERO;
        Set<String> productIds = cartService.getChooseProductIds(LocalUser.getUser().getUserId());
        List<String> productImgs = new ArrayList<>(productIds.size());
        for (String productId : productIds) {
            Product product = productService.getDefaultPictureById(productId);
            if (product.getUnitsInStock() > 0) {
                Long productNums = cartService.getCounts(LocalUser.getUser().getUserId(), productId);
                totalProductNums += productNums;
                totalProductPrice = totalProductPrice.add(product.getSalePrice().multiply(BigDecimal.valueOf(productNums)));
                productImgs.add(product.getDefaultPicture().getPictureUrl());
            }
        }
        submitOrder.setTotalProductNums(totalProductNums);
        submitOrder.setProductImgs(productImgs);
        submitOrder.setTotalProductPrice(StringFormat.format(totalProductPrice));

        // 优惠券
        List<CouponCode> couponCodes = couponService.getCouponCodeByUser(LocalUser.getUser().getUserId());
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
        BigDecimal couponAmount = BigDecimal.ZERO;
        if (payment != null && payment.getTicketId() !=null && !"".equals(payment.getTicketId())) {
            CouponCode couponCode;
            try {
                couponCode = couponService.getCouponById(payment.getTicketId());
            }catch (Exception e) {
                logger.error("优惠券不正确");
                throw new OrderException(StatusCode.COUPON_EXCEPTION);
            }
            couponAmount = couponCode.getCoupon().getFaceValue();
        }
        submitOrder.setCouponAmount(StringFormat.format(couponAmount));

        // 总得价格
        submitOrder.setTotalPrice(StringFormat.format(totalProductPrice.add(freight).subtract(couponAmount)));
        return submitOrder;
    }

    /** 购买商品列表 **/
    public List<ProductList> getProductList() {
        List<ProductModel> productModels = cartService.getChooseProductInfo(LocalUser.getUser().getUserId());
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

    public BuyInfo buy(PaymentDto payment, HttpServletRequest request) {
        // 商品总金额
        BigDecimal totalProductPrice = BigDecimal.ZERO;
        List<ProductModel> productModels = cartService.getChooseProductInfo(LocalUser.getUser().getUserId());
        for (int i=0; i<productModels.size(); i++) {
            Product product = productService.getById(productModels.get(i).getId());
            int counts = productModels.get(i).getCount();
            totalProductPrice = totalProductPrice.add(product.getSalePrice().multiply(BigDecimal.valueOf(counts)));
            productService.updateStockById(product.getId(), product.getUnitsInStock()-counts, false);
        }

        // 生成订单号
        OrderInfo order = new OrderInfo();
        String oid = RandomStringUtils.randomNumeric(8); //TODO
        order.setOid(oid);
        order.setAccountId(LocalUser.getUser().getUserId());

        // 配送地址
        if (payment!=null && payment.getAddrId() != null && !"".equals(payment.getAddrId())) {
            if (payment.getSince()) {
                ArayacakAddress arayacakAddress = orderService.getArayacakAddressById(payment.getAddrId());
                Member member = userService.getMemberByAccountId(LocalUser.getUser().getUserId());
                order.setMobile(member.getMobile());
                order.setAddress(arayacakAddress.getAddress());
                order.setSince(true);
            }else {
                DeliveryAddress addr = userService.getDeliveryAddress(payment.getAddrId(), LocalUser.getUser().getUserId());
                order.setMobile(addr.getMobile());
                order.setVillage(addr.getVillageId()); // TODO 改成名字
                order.setAddress(addr.getAddress());
                order.setPostCode(addr.getPostCode());
                order.setTelephone(addr.getTelephone());
                order.setEmail(addr.getEmail());
                order.setSince(false);
            }
        }else {
            DeliveryAddress addr = userService.getDefaultAddress(LocalUser.getUser().getUserId());
            order.setConsignee(addr.getConsignee());
            order.setMobile(addr.getMobile());
            order.setVillage(addr.getVillageId());
            order.setAddress(addr.getAddress());
            order.setPostCode(addr.getPostCode());
            order.setTelephone(addr.getTelephone());
            order.setEmail(addr.getEmail());
            order.setSince(false);
        }

        // 支付工具
        String payId;
        if (payment !=null && payment.getPayId()!=null && !"".equals(payment.getPayId())) {
            payId = payment.getPayId();
        }else {
            Pay pay = orderService.getRecommendPay();
            payId = pay.getId();
        }
        Pay pay = orderService.getPay(payId);
        order.setPayWay(pay.getPayWay());
        List<FlowStatus> statuses = null;
        if (PayWay.ONLINE.equals(pay.getPayWay())) {
            order.setOrderStatus(OrderStatus.WAIT_PAY);
            statuses = orderService.getFlowStatusesByPayWay(PayWay.ONLINE);
        } else if (PayWay.OFFLINE.equals(pay.getPayWay())) {
            order.setOrderStatus(OrderStatus.ONGOING);
            statuses = orderService.getFlowStatusesByPayWay(PayWay.OFFLINE);
        }
        order.setFlowStatus(statuses.get(0).getId());

        // 送货时间
        DeliveryTime time = orderService.getDeliveryTime(payment.getTimeId());
        order.setDeliveryTime(time.getName());
        order.setPay(pay.getName());
        order.setOrderType(OrderType.NORMAL);

        // 计算运费
        order.setFreightPayable(BigDecimal.valueOf(2L)); // 应付运费 // TODO 应从库里取
        if (totalProductPrice.compareTo(BigDecimal.valueOf(5L))==1
                || totalProductPrice.compareTo(BigDecimal.valueOf(5L)) == 0) { // TODO 应从库里取
            order.setFreightReduce(BigDecimal.valueOf(2L));
        } else {
            order.setFreightReduce(BigDecimal.ZERO);
        }
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
            couponRecord.setAccountId(LocalUser.getUser().getUserId());
            couponRecord.setCouponCodeId(couponCode.getId());
            couponRecord.setTxType("支出");
            couponRecord.setTxResult("消费一张优惠券金额为"+ StringFormat.format(couponCode.getCoupon().getFaceValue()));
            userService.addCouponRecord(couponRecord);
            couponService.updateCouponUsedById(couponCode.getId());

            // TODO 去删除该优惠券
        }
        order.setCouponReducePrice(couponReducePrice);
        order.setBonusPointReducePrice(BigDecimal.ZERO); // 积分优惠 //TODO 积分等级优惠政策

        // 应付金额 = 商品总金额 + 应付运费 - 运费优惠 - 优惠金额 - 券优惠 - 积分优惠
        order.setAmountPayable(totalProductPrice.add(order.getFreightPayable()).subtract(order.getFreightReduce())
                .subtract(order.getDiscount()).subtract(order.getCouponReducePrice()).subtract(order.getBonusPointReducePrice()));

        // 积分金额 = 商品总金额 - 优惠金额 - 券优惠 - 积分优惠
        BigDecimal pointAmount = totalProductPrice.subtract(order.getDiscount())
                .subtract(order.getCouponReducePrice()).subtract(order.getBonusPointReducePrice());
        int bonusPoints = pointAmount.multiply(BigDecimal.TEN).intValue(); // 1毛=1积分

        // 账户更新
        Account account = userService.getAccount(LocalUser.getUser().getUserId());

        // 是否是用余额支付
        if(payment.getBalance()) {
            BigDecimal balance = null;
            BigDecimal totalPrice = totalProductPrice.add(order.getFreightPayable()).subtract(order.getFreightReduce());
            if (account.getBalance().compareTo(totalPrice) == 1 || account.getBalance().compareTo(totalPrice) == 0) {
                balance = account.getBalance().subtract(totalPrice);
                order.setBalanceOffset(totalPrice);
                // 线上支付 如果全部用余额支付的则状态改为进行中，物流状态改为已付款
                if (PayWay.ONLINE.equals(pay.getPayWay())) {
                    order.setOrderStatus(OrderStatus.ONGOING);
                    statuses = orderService.getFlowStatusesByPayWay(PayWay.ONLINE);
                    order.setFlowStatus(order.getFlowStatus()+"-"+statuses.get(0).getNextStatusId());
                }
                //else if (PayWay.OFFLINE.equals(pay.getPayWay())) {}
            }else if (account.getBalance().compareTo(totalPrice) == -1) {
                order.setBalanceOffset(account.getBalance());
                balance = BigDecimal.ZERO;
            }
            account.setBalance(balance);
        }

        // 积分信息更新
        account.setBonusPointUsable(account.getBonusPointUsable()+bonusPoints);
        if (account.getBonusPointUpgrade()-bonusPoints > 0) {
            account.setBonusPointUpgrade(account.getBonusPointUpgrade()-bonusPoints);
        }else {
            AccountLevel level = userService.getAccountLevelById(account.getAccountLevelId());
            AccountLevel accountLevel = userService.getAccountLevelByLevel(level.getLevel()+1); // 升一级
            int residuePoint = Math.abs(account.getBonusPointUpgrade() - bonusPoints);
            account.setBonusPointUpgrade(accountLevel.getNextLevelNeedPoint() - residuePoint);
            account.setAccountLevelId(accountLevel.getId());
        }
        userService.updateAccount(account);

        BigDecimal amountPaid = BigDecimal.ZERO;
        if (payment.getBalance()) { // 是否是用余额支付
            amountPaid = order.getBalanceOffset();
        }
        order.setAmountPaid(amountPaid);

        // 余额没抵扣完的 走到等待用户支付页面
        boolean isPay = false;
        BigDecimal surplusAmount = order.getAmountPayable().subtract(order.getAmountPaid()); // 余额抵扣完还需支付的金额
        if (surplusAmount.compareTo(BigDecimal.ZERO) == 1) {
            if (PayWay.ONLINE.equals(pay.getPayWay())) {
                isPay = true;
            }
        }

        order.setRemarkCustomer(payment.getRemark());
        order.setIp(SystemUtils.getRemoteAddr(request));
        order.setPayTime(new Date());
        order.setFreeAccountLevel(Boolean.FALSE);
        OrderInfo info = orderService.addOrder(order);

        // 该订单下的详细商品信息
        for (ProductModel productModel : productModels) {
            Product product = productService.getById(productModel.getId());
            OrderProductDetail detail = new OrderProductDetail();
            detail.setOrderInfoId(info.getId());
            detail.setOid(info.getOid());
            detail.setName(product.getName());
            detail.setQuantity(productModel.getCount());
            detail.setSubtotal(product.getSalePrice().multiply(BigDecimal.valueOf(productModel.getCount())));
            detail.setMarketPrice(product.getMarketPrice());
            detail.setSalePrice(product.getSalePrice());
            detail.setDealPrice(product.getSalePrice());
            detail.setDiscountRate(1D);
            detail.setComment(false);
            detail.setGift(false);
            orderService.addOrderDetail(detail);
        }
        cartService.deletedChooseProduct(LocalUser.getUser().getUserId());

        // 积分记录
        BonusPointRecord bonusPoint = userService.getBonusPointRecord(LocalUser.getUser().getUserId());
        BonusPointRecord bonusPointRecord = new BonusPointRecord();
        bonusPointRecord.setAccountId(LocalUser.getUser().getUserId());
        bonusPointRecord.setTxBonusPoints(bonusPoints);
        bonusPointRecord.setFrozenBonusPoints(bonusPoints);
        if (bonusPoint != null) {
            bonusPointRecord.setBeforeBonusPoints(bonusPoint.getAfterBonusPoints());
            bonusPointRecord.setAfterBonusPoints(bonusPoint.getAfterBonusPoints()+bonusPoints);
        }else {
            bonusPointRecord.setBeforeBonusPoints(0);
            bonusPointRecord.setAfterBonusPoints(bonusPoints);
        }
        bonusPointRecord.setTxResult("下单获取"+bonusPoints+"积分");
        bonusPointRecord.setTxType(TXType.EARNING);
        userService.addBonusPointRecord(bonusPointRecord);

        // 现金记录
        if (payment.getBalance()) {
            CashRecord cash = userService.getNewCashRecord(LocalUser.getUser().getUserId());
            if (cash == null) {
                throw new BusinessException("请先充值");
            }

            CashRecord cashRecord = new CashRecord();
            cashRecord.setAccountId(LocalUser.getUser().getUserId());
            cashRecord.setTxMoney(order.getBalanceOffset());
            cashRecord.setBeforeMoney(cash.getAfterBonusPoints());
            BigDecimal afterBonusPoints = cash.getAfterBonusPoints().subtract(order.getBalanceOffset());
            if (afterBonusPoints.compareTo(BigDecimal.valueOf(-1L)) == -1) {
                throw new BusinessException("余额不足");
            }
            cashRecord.setAfterBonusPoints(afterBonusPoints);
            cashRecord.setTxType(TXType.EXPENSE);
            cashRecord.setTxResult("下单花费"+StringFormat.format(order.getBalanceOffset())+"元");
            userService.addCashRecord(cashRecord);

            // 短信通知用户
            SmsModel smsModel = new SmsModel(); // TODO 加上和优惠券的一起通知
            smsModel.setUserIp(SystemUtils.getRemoteAddr(request));
            smsModel.setPhone(account.getUsername());
            smsModel.setContent(StringFormat.format(order.getBalanceOffset()));
            smsModel.setDate(new Date());
            smsModel.setType(MsgType.NOTICE_CASH_COMSUME);
            rabbitService.sendCashNotify(smsModel);
        }
        BuyInfo buyInfo = new BuyInfo();
        buyInfo.setOrderNum(oid);
        buyInfo.setDeliveryDate(order.getDeliveryTime());
        buyInfo.setSurplusAmount(StringFormat.format(surplusAmount));
        buyInfo.setPay(isPay);
        buyInfo.setPayName(pay.getName());
        buyInfo.setOffline(PayWay.OFFLINE.equals(pay.getPayWay()));
        return buyInfo;
    }

    public Page<OrderList> getOrders(int pageNum, int pageSize) throws InvocationTargetException, IllegalAccessException {
        PageInfo<OrderInfo> orderInfos = orderService.getOrderInfos(LocalUser.getUser().getUserId(), pageNum, pageSize);
        List<OrderList> orders = new ArrayList<>();
        for (OrderInfo order : orderInfos.getList()) {
            OrderList orderList = new OrderList();
            orderList.setId(order.getId());
            orderList.setDate(new DateTime(order.getCreateDate()).toString("yyyy-dd-MM HH:mm:ss"));
            orderList.setOrderNum(order.getOid());
            orderList.setNumber(order.getOrderDetails().size()+"");
            orderList.setTotalPrice(StringFormat.format(order.getAmountPayable()));

            if (OrderStatus.WAIT_PAY.equals(order.getOrderStatus())) {
                orderList.setOrderStatus(OrderStatus.WAIT_PAY.name());
            }else if (OrderStatus.PAY_OUT_TIME.equals(order.getOrderStatus())) {
                orderList.setOrderStatus(OrderStatus.INVALID.name());
            }else if (OrderStatus.REFUNDED.equals(order.getOrderStatus())
                    || OrderStatus.CANCELED.equals(order.getOrderStatus())
                    || OrderStatus.UNFINISHED.equals(order.getOrderStatus())
                    || OrderStatus.COMMENT.equals(order.getOrderStatus())) {
                orderList.setOrderStatus(OrderStatus.COMMENT.name());
            }else if (OrderStatus.ONGOING.equals(order.getOrderStatus())
                    || OrderStatus.WAIT_REFUND.equals(order.getOrderStatus())){
                orderList.setOrderStatus(OrderStatus.ONGOING.name());
            }else {
                orderList.setOrderStatus(OrderStatus.FINISHED.name());
            }

            // 进行中的订单才会有下面的流程
            List<Status> statuses = new ArrayList<>();
            if (OrderStatus.WAIT_PAY.equals(order.getOrderStatus())
                    ||OrderStatus.ONGOING.equals(order.getOrderStatus())) {
                List<FlowStatus> flowStatuses = orderService.getFlowStatusesByPayWay(order.getPayWay());
                String[] activeStatuses = order.getFlowStatus().split("-");
                for (FlowStatus flowStatus : flowStatuses) {
                    boolean flag = false;
                    for (String statusId : activeStatuses) {
                        if (statusId.equals(flowStatus.getId())) {
                            statuses.add(new Status(flowStatus.getName(), true));
                            flag = true;
                        }
                    }
                    if (!flag)
                        statuses.add(new Status(flowStatus.getName(), false));
                }
            }else {
                String[] activeStatuses = order.getFlowStatus().split("-");
                for (String statusId : activeStatuses) {
                    FlowStatus flowStatus = orderService.getFlowStatusesById(statusId);
                    statuses.add(new Status(flowStatus.getName(), true));
                }
            }
            orderList.setStatuses(statuses);
            orders.add(orderList);
        }
        Page<OrderList> orderInfoPage = new Page<>();
        BeanUtils.copyProperties(orderInfos, orderInfoPage);
        orderInfoPage.setList(orders);
        return orderInfoPage;
    }

    public Detail getOrderDetail() {
        Detail detail = new Detail();
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
        detail.setTotalPrice(StringFormat.format(orderInfo.getAmountPayable()));
        detail.setOrderStatus(orderInfo.getOrderStatus().name());
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
