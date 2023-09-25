package com.cn.zmall.common.exception;

/**
 * 错误码和错误信息定义类
 * 规则：5位数字 前两位代表业务场景 后三位代表错误码
 * 错误码列表：
 * 10:通用
 * -001: 参数格式错误
 * 11:商品
 * 12:订单
 * 13:购物车
 * 14:物流
 */
public enum ErrorCodeEnum {

    UNKNOW_EXCEPTION(10000, "系统未知异常"),

    VALID_EXCEPTION(10001, "参数格式校验失败"),

    SQL_VALID_EXCEPTION(10002,"SQL语句包含非法字符");



    private int code;
    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
