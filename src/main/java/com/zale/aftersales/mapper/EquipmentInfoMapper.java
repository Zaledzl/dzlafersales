package com.zale.aftersales.mapper;

import com.zale.aftersales.model.EquipmentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EquipmentInfoMapper {
    int deleteByPrimaryKey(String equipmentNumber);

    int insert(EquipmentInfo record);

    EquipmentInfo selectByPrimaryKey(String equipmentNumber);

    List<EquipmentInfo> selectAll();

    int updateByPrimaryKey(EquipmentInfo record);
}