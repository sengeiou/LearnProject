package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import com.cocoa.taobao.product_server.dao.ShijiDao;
import com.cocoa.taobao.product_server.dao.TaobaoDao;
import com.cocoa.taobao.product_server.service.IShijiService;
import com.cocoa.taobao.product_server.service.ITaobaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ShijiServiceImpl implements IShijiService {

    @Autowired
    private ShijiDao shijiDao;


    @Override
    public int addItem(ShijiItem commitItem) {
        return shijiDao.insertShiji(commitItem.getItem_url(),
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
                commitItem.getRate());
    }

}
