package com.lzf.dao;

import com.lzf.entity.BizChannel;

import java.util.List;

public interface BizChannelMapper {
    int deleteByPrimaryKey(String id);

    int insert(BizChannel record);

    BizChannel selectByPrimaryKey(String id);

    List<BizChannel> selectAll();

    int updateByPrimaryKey(BizChannel record);

    int insertList(List<BizChannel> list);

}