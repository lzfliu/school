package com.lzf.dao;

import com.lzf.entity.SysRoleUserRelForCas2;
import com.lzf.entity.SysUser;
import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);
    int insertList(List<SysUser> list);
    SysUser selectByPrimaryKey(String id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);
}