package com.lzf.dao;

import com.lzf.entity.CustomerStaffAccount;

import java.util.List;


public interface CustomerStaffAccountMapper {
    int deleteByPrimaryKey(String id);

    int insert(CustomerStaffAccount record);

    CustomerStaffAccount selectByPrimaryKey(String id);

    List<CustomerStaffAccount> selectAll();

    int updateByPrimaryKey(CustomerStaffAccount record);

    void insertList(List<CustomerStaffAccount> staffAccountList);

    CustomerStaffAccount findByLoginName(String loginName);
}