package com.cocoa.taobao.product_server.service;

import com.cocoa.taobao.product_server.bean.sql.IndexBanner;
import org.springframework.data.domain.Page;

public interface BannerService  {

    Page<IndexBanner> getItemsBySize(int size);
}
