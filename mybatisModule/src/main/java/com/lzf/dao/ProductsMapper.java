package com.lzf.dao;

import com.lzf.entity.Products;
import java.util.List;

public interface ProductsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Products record);

    Products selectByPrimaryKey(Integer id);

    List<Products> selectAll();

    int updateByPrimaryKey(Products record);
}