package com.cocoa.taobao.product_server.bean.resp;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BaseResp<T> {

    public static final int DEFAULT_CODE = 0;

    private int code = DEFAULT_CODE;
    private String msg = "ok";
    private T data;

    public void setResultOK(){
        this.code =  DEFAULT_CODE;
        this.msg =  "ok";
    }

    public void setError(int code, String msg){
        this.code =  code;
        this.msg =  msg;
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

    public void setData(T data) {
        this.data = data;
    }

}
