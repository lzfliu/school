package com.lzf.dao;

import com.lzf.entity.ProductFlow;
import com.lzf.entity.ProductLoan;
import java.util.List;

public interface ProductLoanMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductLoan record);
    int insertList(List<ProductLoan> list);
    ProductLoan selectByPrimaryKey(String id);

    List<ProductLoan> selectAll();

    int updateByPrimaryKey(ProductLoan record);
}