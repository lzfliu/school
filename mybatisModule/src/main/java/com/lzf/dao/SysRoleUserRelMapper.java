package com.lzf.dao;

import com.lzf.entity.SysRoleUserRel;
import java.util.List;

public interface SysRoleUserRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleUserRel record);

    SysRoleUserRel selectByPrimaryKey(Integer id);

    List<SysRoleUserRel> selectAll();

    int updateByPrimaryKey(SysRoleUserRel record);

    List<SysRoleUserRel> selectByUserId(String userId);
}