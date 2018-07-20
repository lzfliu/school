package com.lzf.dao;

import com.lzf.entity.DealerProducts;
import java.util.List;

public interface DealerProductsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DealerProducts record);

    DealerProducts selectByPrimaryKey(String id);

    List<DealerProducts> selectAll();

    int updateByPrimaryKey(DealerProducts record);
}