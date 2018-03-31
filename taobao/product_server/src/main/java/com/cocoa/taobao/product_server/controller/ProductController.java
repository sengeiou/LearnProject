package com.cocoa.taobao.product_server.controller;

import com.google.gson.Gson;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//tengxun  118.126.66.230    !     2018-07   RMB120   1核2G、1M带宽
//jd       116.196.79.208    ?      2018-09   RMB188  1核2G
// aliyun   120.79.51.243     ?      2018-11   RMB330  1核1G

/**
 *  ProductController -> get item from taobao
 *  when the month sales getted, save to the mysql
 *  http://open.taobao.com/docs/api.htm?spm=a219a.7629065.0.0.iXAR81&apiId=24515&scopeId=11483
 */
@RestController
@RequestMapping("/product")
@Api(value = "从淘宝客获取商品列表",
        description = "（不进数据库，只单纯的调用淘宝Api，调用端：1.android端查询好销量后进库）"
)
public class ProductController {


    @Value("${taobao.url}")
    public  String url ;
    @Value("${taobao.appkey}")
    public  String appkey ;
    @Value("${taobao.secret}")
    public  String secret ;

    @ApiOperation(value="获取淘宝的商品", notes="根据关键字获取淘宝接口的的商品")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String getProduct(long pageSize, long pageIndex, String keywords) {

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

//        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//        TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
//        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
//        req.setPlatform(1L);
//        req.setNumIids("123,456");
//        TbkItemInfoGetResponse rsp = client.execute(req);
//        System.out.println(rsp.getBody());
        return resp;
    }




}
