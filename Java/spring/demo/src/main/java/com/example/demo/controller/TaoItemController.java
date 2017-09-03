package com.example.demo.controller;

import com.example.demo.bean.CommitItem;
import com.example.demo.resp_bean.CommResp;
import com.example.demo.service.TaoItemService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by sj on 17/8/24.
 */
@Controller
@RequestMapping("/taobao")
public class TaoItemController {

    @Autowired
    private TaoItemService taoItemService;
    @Autowired
    private Gson gson;

//
//    String jsonStr = "{\n" +
//            "          \"item_url\": \"http:\\/\\/item.taobao.com\\/item.htm?id=43189047510\",\n" +
//            "          \"nick\": \"双钱旗舰店\",\n" +
//            "          \"num_iid\": 43189047510,\n" +
//            "          \"pict_url\": \"http:\\/\\/img1.tbcdn.cn\\/tfscom\\/i2\\/2355948914\\/TB1R_QWKFXXXXXUXXXXXXXXXXXX_!!0-item_pic.jpg\",\n" +
//            "          \"provcity\": \"广西 梧州\",\n" +
//            "          \"reserve_price\": \"69.00\",\n" +
//            "          \"seller_id\": 2355948914,\n" +
//            "          \"small_img\":\"http:\\/\\/img2.tbcdn.cn\\/tfscom\\/i2\\/2355948914\\/TB2E5fPnbFkpuFjy1XcXXclapXa_!!2355948914.jpg@http:\\/\\/img1.tbcdn.cn\\/tfscom\\/i4\\/2355948914\\/TB2.4VMbFXXXXXpXpXXXXXXXXXX_!!2355948914.jpg@http:\\/\\/img1.tbcdn.cn\\/tfscom\\/i3\\/2355948914\\/TB2eAcNpHlmpuFjSZFlXXbdQXXa_!!2355948914.jpg\",\n" +
//            "          \"title\": \"双钱龟苓膏原味易拉罐礼盒|7月生产|250克X12罐\",\n" +
//            "          \"user_type\": 1,\n" +
//            "          \"volume\": 3153,\n" +
//            "          \"zk_final_price\": \"41.80\"\n" +
//            "        }";


    @RequestMapping(value = "/addItem", method = RequestMethod.GET)
    @ResponseBody
    public CommResp<String> insertTaoItem(String json) {

        CommitItem commitItem = gson.fromJson(json, CommitItem.class);

        commitItem.setItem_id(commitItem.getItem_url().split("id=")[1]);
        commitItem.setCreate_time(new Date());
        commitItem.setSales_update_time(new Date());

        int result = taoItemService.insertItem(commitItem);

        CommResp commResp = new CommResp();
        commResp.setMsg("update item " + result);

        if (result > 0) {
            commResp.setCode(CommResp.RESULT_OK);
        } else {
            commResp.setCode(CommResp.RESULT_ERROR);
        }
        return commResp;
    }

}
