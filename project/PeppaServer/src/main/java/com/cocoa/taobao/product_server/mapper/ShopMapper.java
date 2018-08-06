package com.cocoa.taobao.product_server.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.cocoa.taobao.product_server.bean.sql.Shop;
import org.apache.ibatis.annotations.Select;

/**
*  @author author
*/
public interface ShopMapper{

    int insertShop(Shop object);

    int updateShop(Shop object);

    int update(Shop.UpdateBuilder object);

    List<Shop> queryShop(Shop object);

    Shop queryShopLimit1(Shop object);

    @Select("SELECT *FROM shop sort ")
    List<Shop> findAll();

    int updateStatus(@Param("shop_id") int shop_id,@Param("status") int status);
}