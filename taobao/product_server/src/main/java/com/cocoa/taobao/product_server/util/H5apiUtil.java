package com.cocoa.taobao.product_server.util;

import com.cocoa.taobao.product_server.bean.h5.H5apiData;
import com.cocoa.taobao.product_server.bean.h5.H5apiJson;

public class H5apiUtil {

    static String url = "http://h5api.m.taobao.com/h5/mtop.taobao.detail.getdetail/6.0/?jsv=2.4.8&appKey=12574478&t=1513130908745&sign=4cca0b2f4172fb146369c9b59f3b5116&api=mtop.taobao.detail.getdetail&v=6.0&ttid=2016%40taobao_h5_2.0.0&isSec=0&ecode=0&AntiFlood=true&AntiCreep=true&H5Request=true&type=jsonp&dataType=jsonp&callback=mtopjsonp1&data=%7B%22exParams%22%3A%22%7B%5C%22id%5C%22%3A%5C%22%s%5C%22%7D%22%2C%22itemNumId%22%3A%22%s%22%7D";

    public static String getH5Data(String num_iid) throws Exception{
        String message = OkHttpUtil.getRequest(url.replace("%s", num_iid));
        message = message.replace("mtopjsonp1(", "");
        message = message.substring(0, message.length() - 1);
        return  message;
    }


}
