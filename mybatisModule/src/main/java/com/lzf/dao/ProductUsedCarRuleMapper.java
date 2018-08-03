package com.lzf.dao;

import com.lzf.entity.ProductUsedCarRule;

import java.util.List;

public interface ProductUsedCarRuleMapper {
    int insert(ProductUsedCarRule record);
    int insertList(List<ProductUsedCarRule> list);
    List<ProductUsedCarRule> selectAll();
}