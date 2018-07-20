package com.lzf.dao;

import com.lzf.entity.ProductLoans;
import java.util.List;

public interface ProductLoansMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductLoans record);

    ProductLoans selectByPrimaryKey(Integer id);

    List<ProductLoans> selectAll();

    int updateByPrimaryKey(ProductLoans record);
}