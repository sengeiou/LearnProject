package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import com.cocoa.taobao.product_server.dao.TaobaoDao;
import com.cocoa.taobao.product_server.service.ITaobaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class TaobaoServiceImpl implements ITaobaoService {

    @Autowired
    private TaobaoDao taobaoDao;

    @Override
    public CommitItem addItem(CommitItem commitItem) {
        return taobaoDao.save(commitItem);
    }

    public List<CommitItem> addItems(ArrayList<CommitItem> commitItems) {
        return taobaoDao.save(commitItems);
    }

    public void flush(){
        taobaoDao.flush();
    }

    @Override
    public int updateStatus(String num_iid, int status) {
        return taobaoDao.updateStatus(num_iid, status);
    }

    @Override
    public Page findAll(String keywords, int status, Integer size, Integer page) {
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.DESC, "sales");
        CommitItem commitItem = new CommitItem();
        commitItem.setStatus(status);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact()).
                        withIgnorePaths("id").
                        withIgnorePaths("sales").
                        withIgnorePaths("tb_from").
                        withIgnorePaths("small_img");
        if (keywords != null && !"".equals(keywords)) {
            commitItem.setTitle(keywords);
            matcher = matcher.withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains());
        }
        return taobaoDao.findAll(Example.of(commitItem, matcher), pageRequest);
    }

    @Override
    public CommitItem getItem(String num_iid) {
        CommitItem item = new CommitItem();
        item.setNum_iid(num_iid);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("num_iid", ExampleMatcher.GenericPropertyMatchers.exact()).
                        withIgnorePaths("id").
                        withIgnorePaths("status").
                        withIgnorePaths("tb_from").
                        withIgnorePaths("sales").
                        withIgnorePaths("small_img");
        Example e = Example.of(item, matcher);
        return taobaoDao.findOne(e);
    }

    @Override
    public Page findByStatusAndTitleLike(int status,String title,Pageable pageable) {
        return taobaoDao.findByStatusAndTitleLike(status,title,pageable);
    }

//    @Override
//    public int updateItem(CommitItem commitItem){
//        return 0;
//    }
}
