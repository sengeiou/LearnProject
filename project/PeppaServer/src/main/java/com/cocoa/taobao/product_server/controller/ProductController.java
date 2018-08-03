package com.cocoa.taobao.product_server.controller;

import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.bean.taobao.TaobaoRespItem;
import com.cocoa.taobao.product_server.impl.ProductImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//tengxun  118.126.66.230    !     2018-07   RMB120   1核2G、1M带宽
//jd       116.196.79.208    ?      2018-09   RMB188  1核2G
// aliyun   120.79.51.243     ?      2018-11   RMB330  1核1G

/**
 * ProductController -> get item from taobao
 * when the month sales getted, save to the mysql
 * http://open.taobao.com/docs/api.htm?spm=a219a.7629065.0.0.iXAR81&apiId=24515&scopeId=11483
 */
@RestController
@RequestMapping("/product")
@Api(value = "从淘宝客获取商品列表",
        description = "（不进数据库，只单纯的调用淘宝Api，调用端：1.android端查询好销量后进库）"
)
public class ProductController {

    @Autowired
    public ProductImpl productImpl;

    @Autowired
    private BaseResp baseResp;

    @ApiOperation(value = "获取淘宝的商品", notes = "根据关键字获取淘宝接口的的商品")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public BaseResp<List<TaobaoRespItem>> getProduct(long pageSize, long pageIndex, String keywords) {
        List<TaobaoRespItem> data = productImpl.getItems(keywords, pageSize, pageIndex);

        if (data == null) {
            return baseResp.setError(100, "error");
        }
        baseResp.setResultOK();
        baseResp.setData(data);
        return baseResp;
    }


    /**
     * @param
     * @return
     */
    @ApiOperation(value = "通过id获取淘宝的商品", notes = "根据id获取淘宝的商品,num_iids 可以是多个id，中间逗号隔开")
    @RequestMapping(method = RequestMethod.GET, value = "/getitem")
    public BaseResp<List<TaobaoRespItem>> addShijiFromId(@RequestParam(value = "num_iids", required = true) String num_iids) {
        List<TaobaoRespItem> data = productImpl.getItems(num_iids);
        if (data == null) {
            return baseResp.setError(100, "error");
        }
        baseResp.setResultOK();
        baseResp.setData(data);
        return baseResp;
    }

//
//    /**
//     * @param
//     * @return
//     */
//    @ApiOperation(value = "通过id获取淘宝的商品", notes = "根据id获取淘宝的商品")
//    @RequestMapping(method = RequestMethod.GET, value = "/test")
//    public String test() {
//        productImpl.getItems("", 1L, 1L);
//        return "";
//    }


}
