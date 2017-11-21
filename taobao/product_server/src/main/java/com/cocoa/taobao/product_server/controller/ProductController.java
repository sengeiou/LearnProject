package com.cocoa.taobao.product_server.controller;

import com.cocoa.taobao.product_server.bean.CommitItem;
import com.cocoa.taobao.product_server.dao.ProductDao;
import com.cocoa.taobao.product_server.impl.ProductServiceImpl;
import com.google.gson.Gson;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 *  ProductController -> get item from taobao
 *  when the month sales getted, save to the mysql
 *
 */
@RestController
@RequestMapping("/tb")
public class ProductController {
    public static String url = "http://gw.api.taobao.com/router/rest";
    public static String appkey = "23222740";
    public static String secret = "36b68bc26780160e5d80a129666dcc7f";
    private Gson mGson = new Gson();

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String getProduct(long pageSize, long pageNo, String keywords) {

        System.out.println(keywords);
        System.out.println(pageNo);

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
        req.setPageNo(pageNo);
        req.setPageSize(pageSize);
        String resp = "";
        try {
            TbkItemGetResponse rsp = client.execute(req);
            resp = rsp.getBody();
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return resp;
    }


    @Autowired
    public ProductServiceImpl productService;


    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String insertProduct(String json) {
//     example
//     String json ="{\"item_url\":\"http://item.taobao.com/item.htm?id=527663335376\",\"nick\":\"尊宾家居旗舰店\",\"num_iid\":\"527663335376\",\"pict_url\":\"http://img2.tbcdn.cn/tfscom/i1/732405394/TB1BqHbcInI8KJjSspeXXcwIpXa_!!0-item_pic.jpg\",\"provcity\":\"广东 佛山\",\"reserve_price\":\"14600.00\",\"sales\":1,\"seller_id\":\"732405394\",\"small_img\":\"http://img1.tbcdn.cn/tfscom/i2/732405394/TB29ucldQ7myKJjSZFgXXcT9XXa_!!732405394.jpg@@http://img2.tbcdn.cn/tfscom/i3/732405394/TB2jTT_dTAlyKJjSZPiXXXL2VXa_!!732405394.jpg@@http://img4.tbcdn.cn/tfscom/i3/732405394/TB2S_FQca3PyuJjy1zkXXcjRFXa_!!732405394.jpg@@http://img2.tbcdn.cn/tfscom/i2/732405394/TB26UMhdNwlyKJjSZFsXXar3XXa_!!732405394.jpg@\",\"sqlParams\":[\"http://item.taobao.com/item.htm?id=527663335376\",\"尊宾家居旗舰店\",\"527663335376\",\"http://img2.tbcdn.cn/tfscom/i1/732405394/TB1BqHbcInI8KJjSspeXXcwIpXa_!!0-item_pic.jpg\",\"广东 佛山\",\"14600.00\",\"732405394\",\"http://img1.tbcdn.cn/tfscom/i2/732405394/TB29ucldQ7myKJjSZFgXXcT9XXa_!!732405394.jpg@@http://img2.tbcdn.cn/tfscom/i3/732405394/TB2jTT_dTAlyKJjSZPiXXXL2VXa_!!732405394.jpg@@http://img4.tbcdn.cn/tfscom/i3/732405394/TB2S_FQca3PyuJjy1zkXXcjRFXa_!!732405394.jpg@@http://img2.tbcdn.cn/tfscom/i2/732405394/TB26UMhdNwlyKJjSZFsXXar3XXa_!!732405394.jpg@\",\"尊宾简约现代头层真皮沙发123组合小户型中厚头层皮艺沙发L29A\",\"1\",\"0\",\"7300.00\",1,null,null,null],\"title\":\"尊宾简约现代头层真皮沙发123组合小户型中厚头层皮艺沙发L29A\",\"user_type\":\"1\",\"volume\":\"0\",\"zk_final_price\":\"7300.00\"}";
        CommitItem commitItem = mGson.fromJson(json, CommitItem.class);

        int b = productService.insertProduct(commitItem);
        System.out.println(b);

        return "{\"code\": 0 ,\"msg\":\"ok\"}";
    }


}
