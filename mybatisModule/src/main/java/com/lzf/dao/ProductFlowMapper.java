package com.lzf.dao;

import com.lzf.entity.DealerProducts;
import com.lzf.entity.ProductFlow;
import java.util.List;

public interface ProductFlowMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductFlow record);
    int insertList(List<ProductFlow> list);
    ProductFlow selectByPrimaryKey(String id);

    List<ProductFlow> selectAll();

    int updateByPrimaryKey(ProductFlow record);
}