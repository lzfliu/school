package com.lzf.dao;

import com.lzf.entity.ProductUsedCarRule;
import com.lzf.entity.SysRoleUserRelForCas2;
import java.util.List;

public interface SysRoleUserRelForCas2Mapper {
    int insert(SysRoleUserRelForCas2 record);
    int insertList(List<SysRoleUserRelForCas2> list);
    List<SysRoleUserRelForCas2> selectAll();
}