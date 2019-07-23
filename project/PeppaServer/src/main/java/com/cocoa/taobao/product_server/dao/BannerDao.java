package com.cocoa.taobao.product_server.dao;

import com.cocoa.taobao.product_server.bean.sql.IndexBanner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerDao extends JpaRepository<IndexBanner, Long> {

}
