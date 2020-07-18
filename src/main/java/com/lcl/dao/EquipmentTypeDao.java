package com.lcl.dao;

import com.lcl.bean.Equipment;
import com.lcl.bean.EquipmentType;

import java.util.List;

public interface EquipmentTypeDao {

    /**
     * 查询所有
     * @return 设备类型列表
     */
    List<EquipmentType> findAll();

    /**
     * 根据类型id查询
     * @return 设备类型
     * @param typeId 设备类型id
     */
    EquipmentType findByTypeId(int typeId);

    /**
     * 根据类型名称查询
     * @return 设备类型列表
     * @param typeName 设备类型名称
     */
    List<EquipmentType> findByTypeName(String typeName);

    /**
     * 新增设备类型
     * @param equipmentType 设备类型
     */
    void insert(EquipmentType equipmentType);

    /**
     * 修改设备类型信息
     * @param equipmentType 设备类型
     */
    void update(EquipmentType equipmentType);

    /**
     * 根据设备类型id删除
     * @param typeId
     */
    void deleteByTypeId(int typeId);
}
