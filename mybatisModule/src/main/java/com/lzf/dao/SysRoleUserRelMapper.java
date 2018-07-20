package com.lzf.dao;

import com.lzf.entity.SysRoleUserRel;
import java.util.List;

public interface SysRoleUserRelMapper {
    int insert(SysRoleUserRel record);

    List<SysRoleUserRel> selectAll();
}