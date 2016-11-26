package com.cheng.weixin.web.mobile.exception.message;

import com.cheng.weixin.web.mobile.i18n.Resources;

/**
 * Desc: Ajax 请求时的自定义查询状态码，主要参考Http状态码，但并不完全对应
 * Author: cheng
 * Date: 2016/6/21
 */
public enum StatusCode {
    /** 200请求成功 */
    OK(200),
    /** 207频繁操作 */
    MULTI_STATUS(207),
    /** 303登录失败 */
    LOGIN_FAIL(303),
    /** 400请求参数出错 */
    BAD_REQUEST(400),
    /** 401没有登录 */
    UNAUTHORIZED(401),
    /** 403没有权限 */
    FORBIDDEN(403),
    /** 404找不到页面 */
    NOT_FOUND(404),
    /** 408请求超时 */
    REQUEST_TIMEOUT(408),
    /** 409发生冲突 */
    CONFLICT(409),
    /** 410已被删除 */
    GONE(410),
    /** 423已被锁定 */
    LOCKED(423),
    /** 500服务器出错 */
    INTERNAL_SERVER_ERROR(500),

    /** 用户异常 **/
    USER_EXCEPTION(9100),
    /** 用户不存在 **/
    USER_NOT_EXIST(9101),
    /** 用户存在 **/
    USER_EXIST(9102),
    /** 验证码错误 **/
    USER_VALIDATE_ERROR(9103),
    /** 手机号不存在 **/
    PHONE_NOT_EXIST(9104),

    /** 操作商品发生异常 **/
    PRODUCT_EXCEPTION(9500),
    /** 库存不足 **/
    PRODUCT_STOCK_SHORTAGE(9501),

    /** 订单 **/
    ORDER_EXCEPTION(9600),

    /** 优惠券异常 **/
    COUPON_EXCEPTION(9700),
    /** 优惠券不存在 **/
    COUPON_NOT_EXIST(9701);

    private final Integer value;

    StatusCode(Integer value) {
        this.value = value;
    }
    /**
     * Return the integer value of this status code.
     */
    public Integer value() {
        return this.value;
    }
    public String msg() {
        return Resources.getMessage("STATUSCODE_" + this.value);
    }

    public String toString() {
        return this.value.toString();
    }
}
