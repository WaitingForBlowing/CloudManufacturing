package com.lcl.dao;

import com.lcl.bean.Equipment;
import com.lcl.bean.Product;

import java.util.List;

public interface EquipmentDao {
    /**
     * 查询所有
     * @return 设备列表
     */
    List<Equipment> findAll();

    /**
     * 根据设备id查询
     * @param equipmentId 设备id
     * @return 设备
     */
    Product findByEquipmentId(int equipmentId);

    /**
     * 通过设备类别id查询
     * @param etId 设备类别id
     * @return 设备列表
     */
    List<Product> findByEquipmentTypeId(int etId);

    /**
     * 新增设备
     * @param equipment 设备
     */
    void insert(Equipment equipment);

    /**
     * 修改设备信息
     * @param equipment 设备
     */
    void update(Equipment equipment);

    /**
     * 根据设备id删除设备
     * @param equipmentId 设备id
     */
    void deleteByEquipmentId(int equipmentId);
}
