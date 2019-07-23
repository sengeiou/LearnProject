package com.cocoa.taobao.product_server.conf;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String url = request.getRequestURI();
//        if(url.contains("getAllItems")){
//            return true;
//        }
//        response.sendRedirect("/product/qiniu/token");
//        return false;
        return super.preHandle(request, response, handler);
    }
}
