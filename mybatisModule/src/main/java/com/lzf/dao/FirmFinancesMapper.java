package com.lzf.dao;

import com.lzf.entity.FirmFinances;
import java.util.List;

public interface FirmFinancesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirmFinances record);

    FirmFinances selectByPrimaryKey(Integer id);

    List<FirmFinances> selectAll();

    int updateByPrimaryKey(FirmFinances record);
}