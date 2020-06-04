package com.gioppl.lunchboxcabinet.okgo;
/**
 * @author admin
 * 描述:     请求基类
 * 作者:     梁亚龙
 * 时间:     2019/12/28
 * 版本:     1.0
 */
public class MyResponse<T> {
    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
