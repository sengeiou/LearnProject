package com.cocoa.taobao.product_server.mapper;

import java.util.List;

import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import org.apache.ibatis.annotations.Param;

/**
 * @author author
 */
public interface ShijiItemMapper {

    int insertShijiItem(ShijiItem object);

    int updateShijiItem(ShijiItem object);

    int updateShijiItemByNumiid(ShijiItem object);

    int update(ShijiItem.UpdateBuilder object);

    List<ShijiItem> queryShijiItem(ShijiItem object);

    ShijiItem queryShijiItemLimit1(ShijiItem object);

    List<ShijiItem> queryShijiItemByTitle(@Param("title") String title, @Param("status") Integer status,@Param("num_iid") String num_iid);

    List<ShijiItem> findByNumIids(@Param("numIids") List<String> numIids);


}