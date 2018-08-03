package com.lzf.dao;

import com.lzf.entity.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(Product record);
    int insertList(List<Product> list);
    Product selectByPrimaryKey(String id);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);
}