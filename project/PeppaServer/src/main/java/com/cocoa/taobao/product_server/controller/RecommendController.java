package com.cocoa.taobao.product_server.controller;

import com.alibaba.fastjson.JSON;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.bean.rmd.BaseRmdItem;
import com.cocoa.taobao.product_server.bean.page.PageModel;
import com.cocoa.taobao.product_server.bean.rmd.RmdDetail;
import com.cocoa.taobao.product_server.bean.rmd.RmdItem;
import com.cocoa.taobao.product_server.bean.rmd.RmdPostBean;
import com.cocoa.taobao.product_server.bean.status.RecommendStatus;
import com.cocoa.taobao.product_server.impl.ItemDetailDaoImpl;
import com.cocoa.taobao.product_server.util.TextUtil;
import com.google.gson.Gson;
import com.mongodb.WriteResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rmd")
public class RecommendController {

    @Autowired
    public ItemDetailDaoImpl itemDetailService;

    @Autowired
    private BaseResp baseResp;

    @Value("${mongodb-recommend}")
    String mongoRrcommend;


    @ApiOperation(value = "添加一个推荐", notes = "")
    @RequestMapping(method = RequestMethod.POST, value = "/add/item")
    public BaseResp addItem(@RequestBody String data) {

        RmdPostBean rmdPostBean = JSON.parseObject(data, RmdPostBean.class);
        if(rmdPostBean == null){
            return baseResp.setError(100, "check params [data], parse object is null ;");
        }
        RmdItem item = rmdPostBean.getParams();

        System.out.println(item);
        item.setCreateDate(System.currentTimeMillis());
        item.setUpdateDate(System.currentTimeMillis());
        item.setStatus(RecommendStatus.ONLINE.getValue());
        itemDetailService.insertOne(item, mongoRrcommend);

        return baseResp.setResultOK().setData(null);
    }


    @ApiOperation(value = "根据id查询推荐的详情", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/get/item")
    public BaseResp getItemById(@RequestParam(value = "id", required = true) String id) {
        return baseResp.setData(itemDetailService.findBy_Id(
                id, RmdItem.class,
                mongoRrcommend)
        );
    }


    @ApiOperation(value = "获取所有的推荐", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/get/all")
    public BaseResp getItems(@RequestParam(value = "size", required = true, defaultValue = "10") int pageSize,
                             @RequestParam(value = "page", required = true, defaultValue = "0") int pageNo,
                             @RequestParam(value = "status", required = true, defaultValue = "") String status,
                             @RequestParam(value = "sort", required = false, defaultValue = "createDate") String sort,
                             @RequestParam(value = "dir", required = false, defaultValue = "desc") String dir,
                             @RequestParam(value = "start", required = false, defaultValue = "") String start,
                             @RequestParam(value = "end", required = false, defaultValue = "") String end

    ) {
        PageModel page = new PageModel();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        RecommendStatus recommendStatus = RecommendStatus.getStatus(status);
        Criteria criteria = new Criteria();
        if (recommendStatus != null) {
            criteria = Criteria.where("status").is(recommendStatus.getValue());
        }

        if (!TextUtil.isEmpty(start) && !TextUtil.isEmpty(end)) {
            Criteria c = new Criteria();
            long startLong = 0L;
            long endLong = 0L;
            try {
                endLong = Long.parseLong(end);
                startLong = Long.parseLong(start);
            } catch (NumberFormatException e) {
                return baseResp.setError(100, "check params [start,end] ;" + e.toString());
            }
            if (startLong != 0L && endLong != 0L) {
                if (startLong == endLong) {
                    criteria = criteria.andOperator(Criteria.where("createDate").is(endLong));
                } else if (startLong < endLong) {
                    c.andOperator(Criteria.where("createDate").lte(endLong), Criteria.where("createDate").gte(startLong));
                    criteria = criteria.andOperator(c);
                }
            } else {
                if (startLong != 0) {
                    criteria = criteria.andOperator(Criteria.where("createDate").gte(startLong));
                }
                if (endLong != 0) {
                    criteria = criteria.andOperator(Criteria.where("createDate").lte(endLong));
                }
            }
        }
        Sort.Direction direction = "DESC".equalsIgnoreCase(dir) ? Sort.Direction.DESC : Sort.Direction.ASC;
        return baseResp.setResultOK().setData(itemDetailService.findSortListTotal(
                page,
                sort,
                direction,
                criteria,
                RmdItem.class,
                mongoRrcommend)
        );
    }


    @ApiOperation(value = "", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/update/status")
    public BaseResp updateStatus(@RequestParam(value = "id", required = true, defaultValue = "id") String id,
                                 @RequestParam(value = "status", required = true, defaultValue = "online") String status) {
        Update update = new Update();

        RecommendStatus recommendStatus = RecommendStatus.getStatus(status);
        if (recommendStatus == null) {
            return baseResp.setError(100, status + " status not found;");
        }

        update.set("status", recommendStatus.getValue());
        return baseResp.setResultOK().setData(itemDetailService.update(
                id,
                update,
                mongoRrcommend)
        );
    }

    @ApiOperation(value = "获取状态信息", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/get/status")
    public BaseResp getStatusInfo() {
        return baseResp.setResultOK().setData(RecommendStatus.getStatusInfo());
    }


    @ApiOperation(value = "更新一个推荐的基础信息", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/update/info")
    public BaseResp updateInfo(@RequestParam(value = "id", required = true, defaultValue = "") String id,
                               @RequestParam(value = "title", required = false, defaultValue = "") String title,
                               @RequestParam(value = "banner", required = false, defaultValue = "") String banner,
                               @RequestParam(value = "status", required = false, defaultValue = "") String status,
                               @RequestParam(value = "like", required = false, defaultValue = "") String like,
                               @RequestParam(value = "view", required = false, defaultValue = "") String view) {
        if (TextUtil.isEmpty(id)) {
            return baseResp.setError(100, "check params [id];");
        }

        // fix 需要改进，写的太乱
        Update update = new Update();
        if (!TextUtil.isEmpty(like)) {
            try {
                Long.parseLong(like);
            } catch (NumberFormatException e) {
                return baseResp.setError(100, "check params [like] ;" + e.toString());
            }
            update.set("likeCount", like);
        }
        if (!TextUtil.isEmpty(view)) {
            try {
                Long.parseLong(view);
            } catch (NumberFormatException e) {
                return baseResp.setError(100, "check params [view] ;" + e.toString());
            }
            update.set("viewCount", view);
        }
        if (!TextUtil.isEmpty(title)) {
            update.set("title", title);
        }
        if (!TextUtil.isEmpty(banner)) {
            update.set("bannerImg", banner);
        }

        if (!TextUtil.isEmpty(status)) {
            RecommendStatus rmdStatus = RecommendStatus.getStatus(status);
            if (rmdStatus == null) {
                return baseResp.setError(100, "check params [status] ; not found this status;");
            }
            update.set("status", rmdStatus.getValue());
        }

        if(update.getUpdateObject().toMap().size() == 0){
             return baseResp.setError(100, "check params ; nothing changed; ");
        }
        update.set("updateDate", System.currentTimeMillis());

        WriteResult result = null;
        try {
            result = itemDetailService.update(
                    id,
                    update,
                    mongoRrcommend);
        } catch (Exception e) {
            return baseResp.setError(100, e.toString());
        }

        if (result == null) {
            return baseResp.setError(100, "update failed;");
        }

        return baseResp.setResultOK().setData(result);
    }
}
