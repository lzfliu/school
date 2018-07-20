package com.lzf.dao;

import com.lzf.entity.FirmInsures;
import java.util.List;

public interface FirmInsuresMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirmInsures record);

    FirmInsures selectByPrimaryKey(Integer id);

    List<FirmInsures> selectAll();

    int updateByPrimaryKey(FirmInsures record);
}