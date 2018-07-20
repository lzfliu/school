package com.lzf.dao;

import com.lzf.entity.BizFinancial;
import java.util.List;

public interface BizFinancialMapper {
    int deleteByPrimaryKey(String id);

    int insert(BizFinancial record);

    BizFinancial selectByPrimaryKey(String id);

    List<BizFinancial> selectAll();

    int updateByPrimaryKey(BizFinancial record);
}