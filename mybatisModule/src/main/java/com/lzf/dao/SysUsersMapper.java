package com.lzf.dao;

import com.lzf.entity.SysUsers;
import java.util.List;

public interface SysUsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUsers record);

    SysUsers selectByPrimaryKey(Integer id);

    List<SysUsers> selectAll();

    int updateByPrimaryKey(SysUsers record);

    List<SysUsers> findByParams(SysUsers params);
}