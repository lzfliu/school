package com.lzf.dao;

import com.lzf.entity.DealerProducts;
import java.util.List;

public interface DealerProductsForCas1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DealerProducts record);

    DealerProducts selectByPrimaryKey(Integer id);

    List<DealerProducts> selectAll();

    int updateByPrimaryKey(DealerProducts record);
}