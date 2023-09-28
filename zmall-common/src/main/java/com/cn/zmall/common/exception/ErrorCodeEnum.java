package com.cn.zmall.common.exception;

import lombok.Getter;

/**
 * 错误码和错误信息定义类
 * 规则：5位数字 前两位代表业务场景 后三位代表错误码
 * 错误码列表：
 * 10:通用
 * -001: 参数格式错误
 * -002: 数据类型错误
 * -003: SQL非法
 * 11:商品
 * 12:订单
 * 13:购物车
 * 14:物流
 */
@Getter
public enum ErrorCodeEnum {

    UNKNOW_EXCEPTION(10000, "系统未知异常"),

    VALID_EXCEPTION(10001, "参数格式校验失败"),

    CONVERT_EXCEPTION(10002,"错误的数据类型"),

    SQL_VALID_EXCEPTION(10003,"SQL语句包含非法字符");


    private final int code;
    private final String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
