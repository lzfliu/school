package com.lzf.dao;

import com.lzf.entity.FirmDocuments;
import java.util.List;

public interface FirmDocumentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirmDocuments record);

    FirmDocuments selectByPrimaryKey(Integer id);

    List<FirmDocuments> selectAll();

    int updateByPrimaryKey(FirmDocuments record);
}