package com.cocoa.taobao.product_server.bean.resp;

import com.google.gson.Gson;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class BaseResp<T> implements Serializable{

    public static final int DEFAULT_CODE = 0;


    private int code = DEFAULT_CODE;
    private String msg = "ok";
    private T data;

    public BaseResp setResultOK(){
        this.code =  DEFAULT_CODE;
        this.msg =  "ok";
        return this;
    }

    public BaseResp setError(int code, String msg){
        this.code =  code;
        this.msg =  msg;
        this.data = null;
        return this;
    }


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

    public T getData() {
        return data;
    }

    public BaseResp setData(T data) {
        this.data = data;
        return this;
    }

}
