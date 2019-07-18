package com.ttm.application.action.vo;

import java.util.Collection;

/**
 * <p>@Author tangtaiming</p>
 * <p>@Date 2019-07-17</p>
 * <p>@Version 1.0</p>
 **/
public class ServiceResponse<T extends Object> {

    /**
     * 请求code
     */
    private int code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 请求结果
     */
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
