package com.lzf.dao;

import com.lzf.entity.FirmDealers;
import java.util.List;

public interface FirmDealersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirmDealers record);

    FirmDealers selectByPrimaryKey(Integer id);

    List<FirmDealers> selectAll();

    int updateByPrimaryKey(FirmDealers record);

    List<FirmDealers> selectACP();

    List<FirmDealers> selectSP();

    List<FirmDealers> selectDealer();

}