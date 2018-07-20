package com.lzf.dao;

import com.lzf.entity.DealerAllocation;
import java.util.List;

public interface DealerAllocationMapper {
    int deleteByPrimaryKey(String id);

    int insert(DealerAllocation record);

    DealerAllocation selectByPrimaryKey(String id);

    List<DealerAllocation> selectAll();

    int updateByPrimaryKey(DealerAllocation record);
}