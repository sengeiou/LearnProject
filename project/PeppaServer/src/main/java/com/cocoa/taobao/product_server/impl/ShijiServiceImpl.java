package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import com.cocoa.taobao.product_server.dao.ShijiDao;
import com.cocoa.taobao.product_server.dao.TaobaoDao;
import com.cocoa.taobao.product_server.service.IShijiService;
import com.cocoa.taobao.product_server.service.ITaobaoService;
import com.cocoa.taobao.product_server.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ShijiServiceImpl implements IShijiService {

    @Autowired
    private ShijiDao shijiDao;


    @Override
    public int updateStatus(String num_iid, int status) {
        return shijiDao.updateStatus(num_iid, status);
    }
    @Override
    public int updateSales(String num_iid, int sales) {
        return shijiDao.updateSales(num_iid, sales);
    }

    @Override
    public ShijiItem getItem(String num_iid) {
        ShijiItem item = new ShijiItem();
        item.setNum_iid(num_iid);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("num_iid", ExampleMatcher.GenericPropertyMatchers.exact()).
                        withIgnorePaths("id").
                        withIgnorePaths("status").
                        withIgnorePaths("tb_from").
                        withIgnorePaths("sales").
                        withIgnorePaths("small_img");
        Example e = Example.of(item, matcher);
        return shijiDao.findOne(e);
    }


    @Override
    public Page findAll(String keywords, int status, int size, int page) {
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.DESC, "sales");
        ShijiItem item = new ShijiItem();
        item.setStatus(status);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact()).
                        withIgnorePaths("id").
                        withIgnorePaths("tb_from").
                        withIgnorePaths("sales").
                        withIgnorePaths("small_img");
        if (!TextUtil.isEmpty(keywords)) {
            item.setTitle(keywords);
            matcher = matcher.withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains());
        }
        return shijiDao.findAll(Example.of(item, matcher), pageRequest);
    }

    @Override
    public Page findAll(String keywords, int status, PageRequest pageRequest) {
        ShijiItem item = new ShijiItem();
        item.setStatus(status);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact()).
                        withIgnorePaths("id").
                        withIgnorePaths("tb_from").
                        withIgnorePaths("sales").
                        withIgnorePaths("small_img");
        if (!TextUtil.isEmpty(keywords)) {
            item.setTitle(keywords);
            matcher = matcher.withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains());
        }
        return shijiDao.findAll(Example.of(item, matcher), pageRequest);
    }



    @Override
    public Page findAll(int size, int page, Sort.Direction direction, String sortProp) {
        PageRequest pageRequest = new PageRequest(page, size, direction, sortProp);
        return shijiDao.findAll(pageRequest);
    }


    @Override
    public ShijiItem saveAndUpdate(ShijiItem shijiItem) {
        return shijiDao.save(shijiItem);
    }

}
