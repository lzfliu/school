package com.lzf.dao;

import com.lzf.entity.FirmMortgages;
import java.util.List;

public interface FirmMortgagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirmMortgages record);

    FirmMortgages selectByPrimaryKey(Integer id);

    List<FirmMortgages> selectAll();

    int updateByPrimaryKey(FirmMortgages record);
}