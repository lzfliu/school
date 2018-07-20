package com.lzf.dao;

import com.lzf.entity.FirmHomeVisits;
import java.util.List;

public interface FirmHomeVisitsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirmHomeVisits record);

    FirmHomeVisits selectByPrimaryKey(Integer id);

    List<FirmHomeVisits> selectAll();

    int updateByPrimaryKey(FirmHomeVisits record);
}