package com.lzf.dao;

import com.lzf.entity.FirmCapitals;
import java.util.List;

public interface FirmCapitalsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirmCapitals record);

    FirmCapitals selectByPrimaryKey(Integer id);

    List<FirmCapitals> selectAll();

    int updateByPrimaryKey(FirmCapitals record);
}