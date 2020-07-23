package com.lcl.dao;

import com.lcl.bean.OrderRecord;

import java.util.List;

public interface OrderRecordDao {

    void insert(OrderRecord orderRecord);

    List<OrderRecord> findByOid(int oid);
}
