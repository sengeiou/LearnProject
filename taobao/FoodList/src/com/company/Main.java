package com.company;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;

public class Main extends BaseMain{

    public static void main(String[] args) throws Exception {
//        正式环境	http://gw.api.taobao.com/router/rest	https://eco.taobao.com/router/rest
//        沙箱环境	http://gw.api.tbsandbox.com/router/rest	https://gw.api.tbsandbox.com/router/rest



        System.out.println(Long.toBinaryString(16));

        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        req.setQ("布丁");
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
        req.setPageNo(2L);
//        req.setPageSize(20L);
        TbkItemGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }
}
