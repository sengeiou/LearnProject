package com.company;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.StringUtils;


/**
 * Created by sj on 17/7/3.
 */
public class IteamCats {

    public static void main(String[] args) {
        String url ="http://gw.api.taobao.com/router/rest";
        String appkey ="23222740";
        String secret ="36b68bc26780160e5d80a129666dcc7f";

//        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//        ItemcatsGetRequest req = new ItemcatsGetRequest();
//        req.setCids("18957,19562");
//        req.setDatetime(StringUtils.parseDateTime("2000-01-01 00:00:00"));
//        req.setFields("cid,parent_cid,name,is_parent");
//        req.setParentCid(50011999L);
//        ItemcatsGetResponse rsp = client.execute(req);
//        System.out.println(rsp.getBody());
    }
}
