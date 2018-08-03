package com.lzf.dao;

import com.lzf.entity.BizVisit;

import java.util.List;

public interface BizVisitMapper {
    int deleteByPrimaryKey(String id);

    int insert(BizVisit record);
    int insertList(List<BizVisit> list);
    BizVisit selectByPrimaryKey(String id);

    List<BizVisit> selectAll();

    int updateByPrimaryKey(BizVisit record);
}