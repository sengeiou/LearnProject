package com.cocoa.taobao.product_server.dao;

import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface ShijiDao {  //extends JpaRepository<ShijiItem, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE shiji_item SET status = ?2 WHERE num_iid = ?1", nativeQuery = true)
//    int updateStatus(String num_iid, int status);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE shiji_item SET sales = ?2 WHERE num_iid = ?1", nativeQuery = true)
//    int updateSales(String num_iid, int sales);

}
