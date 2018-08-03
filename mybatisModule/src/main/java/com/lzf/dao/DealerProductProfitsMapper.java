package com.lzf.dao;

import com.lzf.entity.DealerAllocation;
import com.lzf.entity.DealerProductProfits;
import java.util.List;

public interface DealerProductProfitsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DealerProductProfits record);
    int insertList(List<DealerProductProfits> list);
    DealerProductProfits selectByPrimaryKey(String id);

    List<DealerProductProfits> selectAll();

    int updateByPrimaryKey(DealerProductProfits record);
}