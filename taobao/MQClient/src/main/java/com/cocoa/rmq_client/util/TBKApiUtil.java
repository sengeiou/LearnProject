package com.cocoa.rmq_client.util;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;

public class TBKApiUtil {

    public static String url="http://gw.api.taobao.com/router/rest";
    public static String appkey="24532401";
    public static String secret="905826f8463190d96693824da5642a43";

//    public static String url="http://gw.api.taobao.com/router/rest";
//    public static String appkey="23222740";
//    public static String secret="36b68bc26780160e5d80a129666dcc7f";
//

    public static String getItems(String keywords, long pageIndex, long pageSize) {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        req.setQ(keywords);
//        req.setCat("21,23");
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
            resp = rsp.getBody();
        } catch (ApiException e) {
            e.printStackTrace();
        }
       return resp;
    }
}
