package com.example.demo.service;

import com.example.demo.bean.CommitItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sj on 17/8/24.
 */
@Service
public class TaoItemService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int insertItem(CommitItem item) {
        String sql = "INSERT INTO taobao_item (item_url, nick, num_iid, pict_url, provcity, reserve_price, seller_id, small_img, title, user_type, volume, zk_final_price, sales, sales_update_time, create_time, item_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, item.getSqlParams());
    }

}
