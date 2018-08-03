package com.lzf.dao;

import com.lzf.entity.CustomerStaff;
import java.util.List;

public interface CustomerStaffMapper {
    int deleteByPrimaryKey(String id);

    int insert(CustomerStaff record);

    CustomerStaff selectByPrimaryKey(String id);

    List<CustomerStaff> selectAll();

    int updateByPrimaryKey(CustomerStaff record);

    void insertList(List<CustomerStaff> staffList);
}