package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.bean.sql.IndexBanner;
import com.cocoa.taobao.product_server.dao.BannerDao;
import com.cocoa.taobao.product_server.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class BannerDaoImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public Page<IndexBanner> getItemsBySize(int size) {
        PageRequest pageRequest = new PageRequest(0, 5, Sort.Direction.DESC, "create");
        return bannerDao.findAll(pageRequest);
    }
}
