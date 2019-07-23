package com.cocoa.taobao.product_server.controller;


import com.cocoa.taobao.product_server.bean.index.IndexResult;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.bean.page.PageModel;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import com.cocoa.taobao.product_server.bean.status.TBItemStatus;
import com.cocoa.taobao.product_server.impl.BannerDaoImpl;
import com.cocoa.taobao.product_server.impl.ItemDetailDaoImpl;
import com.cocoa.taobao.product_server.impl.ShijiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private BannerDaoImpl bannerDaoImpl;

    @Autowired
    public ItemDetailDaoImpl itemDetailService;

    @Autowired
    private BaseResp baseResp;

    @Autowired
    public ShijiServiceImpl shijiService;

    @Value("${index.default.bannnerSize}")
    private int bannnerSize;

    @Value("${index.default.recommendSize}")
    private int recommendSize;

    @Value("${index.default.itemSize}")
    private int itemSize;

    private static final int pageIndex = 0;

    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public BaseResp index() {


        IndexResult indexResult = new IndexResult();
        // banner
        indexResult.setBanner(bannerDaoImpl.getItemsBySize(bannnerSize));

        // recommend
        PageModel page = new PageModel(recommendSize, pageIndex);
        // DESC whih date
//        List<SimpleRmdList> list = itemDetailService.findSortList(page,
//                "dateLong",
//                Sort.Direction.DESC,
//                SimpleRmdList.class,
//                "rmd");
//        indexResult.setRecommond(list);

        // shiji list
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        PageRequest pageRequest = new PageRequest(pageIndex, itemSize, sort);
//

        baseResp.setData(indexResult);
        return baseResp.setResultOK();
    }

//    https://img.alicdn.com/imgextra/i3/2138581292/TB2ZBW_AmtYBeNjSspaXXaOOFXa_!!2138581292-0-item_pic.jpg_400x400q90.jpg
}
