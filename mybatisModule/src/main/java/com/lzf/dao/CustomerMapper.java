package com.lzf.dao;

import com.lzf.entity.Customer;
import com.lzf.entity.SysCompany;
import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Customer record);

    Customer selectByPrimaryKey(String id);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);

    void insertList(List<SysCompany> list);
}