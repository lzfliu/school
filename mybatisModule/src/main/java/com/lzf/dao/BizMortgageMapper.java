package com.lzf.dao;

import com.lzf.entity.BizMortgage;
import java.util.List;

public interface BizMortgageMapper {
    int deleteByPrimaryKey(String id);

    int insert(BizMortgage record);

    BizMortgage selectByPrimaryKey(String id);

    List<BizMortgage> selectAll();

    int updateByPrimaryKey(BizMortgage record);
}