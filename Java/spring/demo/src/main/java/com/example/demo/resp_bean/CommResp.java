package com.example.demo.resp_bean;

/**
 * Created by sj on 17/8/24.
 */
public class CommResp<T> {

    public static final int RESULT_OK = 1000;
    public static final int RESULT_ERROR = -1;

    private String msg;
    private int code;
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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
}
