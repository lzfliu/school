package com.lzf.dao;

import com.lzf.entity.BizCapital;
import java.util.List;

public interface BizCapitalMapper {
    int deleteByPrimaryKey(String id);

    int insert(BizCapital record);

    BizCapital selectByPrimaryKey(String id);

    List<BizCapital> selectAll();

    int updateByPrimaryKey(BizCapital record);

    int insertList(List<BizCapital> list);
}