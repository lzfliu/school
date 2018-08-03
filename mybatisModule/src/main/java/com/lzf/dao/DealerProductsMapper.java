package com.lzf.dao;

import com.lzf.entity.DealerProductProfits;
import com.lzf.entity.DealerProducts;
import java.util.List;

public interface DealerProductsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DealerProducts record);
    int insertList(List<DealerProducts> list);
    DealerProducts selectByPrimaryKey(String id);

    List<DealerProducts> selectAll();

    int updateByPrimaryKey(DealerProducts record);
}