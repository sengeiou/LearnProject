package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import com.cocoa.taobao.product_server.dao.TaobaoDao;
import com.cocoa.taobao.product_server.service.ITaobaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class TaobaoServiceImpl implements ITaobaoService {

    @Autowired
    private TaobaoDao taobaoDao;

    @Override
    public int addItem(CommitItem commitItem) {
        return taobaoDao.addItem(commitItem.getItem_url(),
                commitItem.getNick(),
                commitItem.getNum_iid(),
                commitItem.getPict_url(),
                commitItem.getProvcity(),
                commitItem.getReserve_price(),
                commitItem.getSeller_id(),
                commitItem.getSmall_img(),
                commitItem.getTitle(),
                commitItem.getUser_type(),
                commitItem.getVolume(),
                commitItem.getZk_final_price(),
                commitItem.getSales(),
                new Date(), new Date(),
                commitItem.getItem_id());
    }


    @Override
    public int updateStatus(long num_iid, int status) {
        return taobaoDao.updateStatus(num_iid, status);
    }

    @Override
    public Page findAll(String keywords, int status, Integer size, Integer page) {
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.DESC, "sales");
        //        taobaoDao.findAll(new Example<>())
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact()).
                        withIgnorePaths("id").
                        withIgnorePaths("sales").
                        withIgnorePaths("small_img");
        CommitItem commitItem = new CommitItem();
        commitItem.setStatus(status);

        return taobaoDao.findAll(Example.of(commitItem, matcher), pageRequest);
    }
}
