package com.lzf.dao;

import com.lzf.entity.DealerProductProfits;
import java.util.List;

public interface DealerProductProfitsForCas1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DealerProductProfits record);

    DealerProductProfits selectByPrimaryKey(Integer id);

    List<DealerProductProfits> selectAll();

    int updateByPrimaryKey(DealerProductProfits record);
}