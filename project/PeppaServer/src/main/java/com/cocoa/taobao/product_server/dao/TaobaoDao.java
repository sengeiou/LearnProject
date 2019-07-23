package com.cocoa.taobao.product_server.dao;

import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


public interface TaobaoDao extends JpaRepository<CommitItem, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "insert into taobao_item(item_url,nick, num_iid,pict_url, provcity, reserve_price, seller_id, small_images, title, user_type, volume, zk_final_price, sales, sales_update_time, create_time, rate) values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16)", nativeQuery = true)
//    int addItem(String item_url,
//                String nick,
//                String num_iid,
//                String pict_url,
//                String provcity,
//                String reserve_price,
//                String seller_id,
//                String small_images,
//                String title,
//                String user_type,
//                String volume,
//                String zk_final_price,
//                int sales,
//                Date sales_update_time,
//                Date create_time,
//                String rate
//    );


    @Transactional
    @Modifying
    @Query(value = "UPDATE taobao_item SET status = ?2 WHERE num_iid = ?1", nativeQuery = true)
    int updateStatus(String num_iid, int status);


//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE taobao_item SET status = ?2 WHERE num_iid = ?1", nativeQuery = true)
//    public int updateItem(CommitItem commitItem);


    Page<CommitItem> findByStatusAndTitleLike(int status,String title,Pageable pageable);

}