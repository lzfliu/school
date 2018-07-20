package com.lzf.dao;

import com.lzf.entity.ProductFlow;
import java.util.List;

public interface ProductFlowMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductFlow record);

    ProductFlow selectByPrimaryKey(String id);

    List<ProductFlow> selectAll();

    int updateByPrimaryKey(ProductFlow record);
}