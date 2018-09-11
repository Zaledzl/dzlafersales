package com.zale.aftersales.service;

import com.zale.aftersales.model.EquipmentInfo;
import com.zale.aftersales.model.Users;

import java.util.List;

public interface EquipmentInfoService {


    List<EquipmentInfo> getEquipmentInfo();


    EquipmentInfo getEquipmentInfoByUsername(String username);


    boolean addEquipmentInfo(EquipmentInfo equipmentInfo);


    boolean updateEquipmentInfo(EquipmentInfo equipmentInfo);


    boolean deleteEquipmentInfo(String username);

}
