package com.lzf.dao;

import com.lzf.entity.Cas1Relation;
import java.util.List;

public interface Cas1RelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cas1Relation record);

    Cas1Relation selectByPrimaryKey(String id);

    List<Cas1Relation> selectAll();

    int updateByPrimaryKey(Cas1Relation record);

    Cas1Relation findByParams(Cas1Relation params);
}