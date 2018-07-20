package com.lzf.dao;

import com.lzf.entity.SysCompany;
import java.util.List;

public interface SysCompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysCompany record);

    SysCompany selectByPrimaryKey(String id);

    List<SysCompany> selectAll();

    int updateByPrimaryKey(SysCompany record);

    SysCompany selectByName(String name);
}