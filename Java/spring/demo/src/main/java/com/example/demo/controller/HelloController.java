package com.example.demo.controller;

import com.example.demo.bean.User;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sj on 17/6/19.
 */
@RestController
@RequestMapping("/")
public class HelloController {
    String url = "http://gw.api.taobao.com/router/rest";
    String appkey = "23222740";
    String secret = "36b68bc26780160e5d80a129666dcc7f";


    @RequestMapping(value = "/taobao", method = RequestMethod.GET)
    @ResponseBody
    public String getTaoItem(String keywords, String pageNo, String pageSize) {

        System.out.println(keywords+"-----"+pageNo+"-----"+pageSize);

        try {
            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            TbkItemGetRequest req = new TbkItemGetRequest();
            req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
            req.setQ(keywords);
//        req.setCat("21,23");
//        req.setItemloc("杭州");
//        req.setSort("tk_rate_des");
//        req.setIsTmall(false);
//        req.setIsOverseas(false);
//        req.setStartPrice(10L);
//        req.setEndPrice(10L);
//        req.setStartTkRate(123L);
//        req.setEndTkRate(123L);
//        req.setPlatform(1L);
            req.setPageNo(Long.parseLong(pageNo));
            req.setPageSize(Long.parseLong(pageSize));
            TbkItemGetResponse rsp = client.execute(req);
            return rsp.getBody();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return "";
    }
}
