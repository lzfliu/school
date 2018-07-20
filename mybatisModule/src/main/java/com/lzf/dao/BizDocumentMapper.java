package com.lzf.dao;

import com.lzf.entity.BizDocument;
import java.util.List;

public interface BizDocumentMapper {
    int insert(BizDocument record);

    List<BizDocument> selectAll();
}