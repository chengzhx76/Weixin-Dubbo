package com.cheng.weixin.service.user.service;

import com.cheng.common.entity.enums.Status;
import com.cheng.weixin.rpc.user.entity.*;
import com.cheng.weixin.rpc.user.enumType.Credit;
import com.cheng.weixin.rpc.user.enumType.Sex;
import com.cheng.weixin.rpc.user.enumType.SourceFrom;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import com.cheng.weixin.service.user.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Desc: 用户
 * Author: cheng
 * Date: 2016/7/7
 */
@Service("userService")
public class UserService implements RpcUserService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountDaoMapper accountDao;
    @Autowired
    private AccountLevelDaoMapper accountLevelDao;
    @Autowired
    private MemberDaoMapper memberDao;
    @Autowired
    private DeliveryAddressDaoMapper deliveryAddressDao;
    @Autowired
    private BehaviorDaoMapper behaviorDao;
    @Autowired
    private BonusPointRecordDaoMapper bonusPointRecordDao;
    @Autowired
    private CouponRecordDaoMapper couponRecordDao;
    @Autowired
    private CashRecordDaoMapper cashRecordDao;
    @Autowired
    private ProductFocusDaoMapper productFocusDao;

    @Override
    public Account getAccountByLoginName(String loginName) {
        return accountDao.load(new Account(null, loginName));
    }

    @Override
    public Account getAccountById(String id) {
        return accountDao.load(new Account(id, null));
    }

    @Override
    public void saveAccess(String phone, String password, String nickname, String ip) {

        if (null != getAccountByLoginName(phone)) {
            logger.info("当前用户{}已存在", phone);
            throw new IllegalArgumentException("当前用户"+phone+"已存在");
        }

        AccountLevel accountLevel = accountLevelDao.load(new AccountLevel(true));

        Account account = new Account();
        account.setUsername(phone);
        account.setPassword(password);
        account.setAccountLevelId(accountLevel.getId());
        account.setBalance(new BigDecimal(0));
        account.setBonusPointUpgrade(accountLevel.getPointEveryLevel());
        account.setBonusPointUsable(0);
        account.setCredit(Credit.WELL);
        account.setEmployee(false);
        account.setIp(ip);
        account.setSourceFrom(SourceFrom.NO);
        account.preInsert();
        accountDao.save(account);

        Member member = new Member();
        member.setAccountId(account.getId());
        member.setNickname(nickname);
        member.setMobile(phone);
        member.setSex(Sex.UNKNOW);
        member.preInsert();
        memberDao.save(member);
    }

    @Override
    public String validateLogin(String loginName, String password, String loginIp) {
        Account userAccount = accountDao.load(new Account(null, loginName));
        if (null != userAccount) {
            if (!password.equals(userAccount.getPassword())) {
                return "PASSWDFAIL";
            }
        }else {
            return "NOTUSER";
        }
        // 登陆成功保存登陆者的IP
        userAccount.setIp(loginIp);
        userAccount.preUpdate();
        accountDao.update(userAccount);
        return "SUCCESS";
    }

    @Override
    public DeliveryAddress getDefaultAddress(String userId) {
        return deliveryAddressDao.load(new DeliveryAddress(userId, true));
    }

    @Override
    public DeliveryAddress getDeliveryAddress(String id, String userId) {
        DeliveryAddress address = new DeliveryAddress();
        address.setId(id);
        address.setAccountId(userId);
        return deliveryAddressDao.load(address);
    }

    @Override
    public List<DeliveryAddress> getAllDeliveryAddr(String userId) {
        return deliveryAddressDao.loadAll(new DeliveryAddress(userId, null));
    }

    @Override
    public Account getAccount(String userId) {
        Account account = new Account();
        account.setId(userId);
        return accountDao.load(account);
    }

    @Override
    public void updateAccount(Account account) {
        account.preUpdate();
        accountDao.update(account);
    }

    @Override
    public void addBehavior(Behavior behavior) {
        behavior.preInsert();
        behaviorDao.save(behavior);
    }

    @Override
    public BonusPointRecord getBonusPointRecord(String userId) {
        return bonusPointRecordDao.loadByUserId(new BonusPointRecord(userId));
    }

    @Override
    public void addBonusPointRecord(BonusPointRecord bonusPointRecord) {
        bonusPointRecord.preInsert();
        bonusPointRecordDao.save(bonusPointRecord);
    }

    @Override
    public CouponRecord getCouponRecordByUser(String userId) {
        return couponRecordDao.loadByUser(new CouponRecord(userId));
    }

    @Override
    public void addCouponRecord(CouponRecord couponRecor) {
        couponRecor.preInsert();
        couponRecordDao.save(couponRecor);
    }

    @Override
    public CashRecord getNewCashRecord(String userId) {
        return cashRecordDao.loadNewByUser(new CashRecord(userId));
    }

    @Override
    public void addCashRecord(CashRecord cashRecord) {
        cashRecord.preInsert();
        cashRecordDao.save(cashRecord);
    }

    @Override
    public void addProductFocus(String userId, String productId) {
        ProductFocus focus = new ProductFocus(userId, productId);
        focus.preInsert();
        productFocusDao.save(focus);
    }

    @Override
    public void deleteProductFocus(String userId, String productId) {
        ProductFocus focus = new ProductFocus(userId, productId);
        focus.setStatus(Status.DELETE);
        focus.preUpdate();
        productFocusDao.delete(focus);
    }

    @Override
    public boolean isProductFocus(String userId, String productId) {
        ProductFocus focus = productFocusDao.load(new ProductFocus(userId, productId));
        return focus!=null;
    }

    @Override
    public Member getMemberById(String userId) {
        return memberDao.load(new Member(userId));
    }
}
