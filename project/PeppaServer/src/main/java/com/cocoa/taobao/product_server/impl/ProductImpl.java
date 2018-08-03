package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.bean.taobao.*;
import com.cocoa.taobao.product_server.service.IProductService;
import com.cocoa.taobao.product_server.util.TextUtil;
import com.google.gson.Gson;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements IProductService {

    @Value("${taobao.url}")
    public String url;
    @Value("${taobao.appkey}")
    public String appkey;
    @Value("${taobao.secret}")
    public String secret;

    public static final Gson mGson = new Gson();


    @Override
    public List<TaobaoRespItem> getItems(String keywords, Long pageSize, Long pageIndex) {

        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        req.setQ(keywords);
        req.setCat("21,23");
//        req.setItemloc("杭州");
        req.setSort("total_sales");  //排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi）
//        req.setIsTmall(false);
//        req.setIsOverseas(false);
//        req.setStartPrice(10L);
//        req.setEndPrice(10L);
//        req.setStartTkRate(123L);
//        req.setEndTkRate(123L);
//        req.setPlatform(1L);  //platform	Number	可选	1		链接形式：1：PC，2：无线，默认：１
        req.setPageNo(pageIndex);
        req.setPageSize(pageSize);
        String resp = "";
        try {
            TbkItemGetResponse rsp = client.execute(req);
            return parseData(rsp.getBody());

        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TaobaoRespItem> getItems(String num_iids) {
        String resp = "";
        try {
            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
            req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
            req.setPlatform(1L);
            req.setNumIids(num_iids);
            TbkItemInfoGetResponse rsp = client.execute(req);
            return parseData(rsp.getBody());

        } catch (Exception e) {
        }
        return null;
    }


    public List<TaobaoRespItem> parseData(String jsonStr) {

        if (TextUtil.isEmpty(jsonStr)) {
            return null;
        }

        System.out.println(jsonStr);

        // 统一两个接口返回的字段
        if (jsonStr.contains("tbk_item_info_get_response")) {
            jsonStr = jsonStr.replace("tbk_item_info_get_response", "tbk_item_get_response");
        }
        if (jsonStr.contains("small_images")) {
            jsonStr = jsonStr.replace("small_images", "small_img");
        }

        TaobaoAllResp taobaoAllResp = mGson.fromJson(jsonStr, TaobaoAllResp.class);

        if (taobaoAllResp == null) {
            return null;
        }
        TaobaoResp taobaoResp = taobaoAllResp.tbk_item_get_response;
        if (taobaoResp == null) {
            return null;
        }

        TaobaoResult taobaoResultDetail = taobaoResp.results;
        if (taobaoResultDetail == null) {
            return null;
        }
        return taobaoResultDetail.n_tbk_item;

    }

}
