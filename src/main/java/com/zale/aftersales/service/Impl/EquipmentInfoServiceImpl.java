package com.zale.aftersales.service.Impl;

import com.zale.aftersales.mapper.EquipmentInfoMapper;
import com.zale.aftersales.model.EquipmentInfo;
import com.zale.aftersales.service.EquipmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipmentInfoServiceImpl implements EquipmentInfoService {

    @Autowired
    private EquipmentInfoMapper equipmentInfoMapper;

    @Override
    public List<EquipmentInfo> getEquipmentInfo() {
        return equipmentInfoMapper.selectAll();
    }

    @Override
    public EquipmentInfo getEquipmentInfoByUsername(String username) {
        return equipmentInfoMapper.selectByPrimaryKey(username);
    }

    @Transactional
    @Override
    public boolean addEquipmentInfo(EquipmentInfo equipmentInfo) {
        if (equipmentInfo.getEquipmentNumber() != null) {
            try {
                int effectedNum = equipmentInfoMapper.insert(equipmentInfo);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("添加设备信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加设备信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("设备信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean updateEquipmentInfo(EquipmentInfo equipmentInfo) {
        if (equipmentInfo.getEquipmentNumber() != null) {
            try {
                int effectedNum = equipmentInfoMapper.updateByPrimaryKey(equipmentInfo);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("更新设备信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新设备信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("设备信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteEquipmentInfo(String username) {
        try {
            // 删除用户信息
            int effectedNum = equipmentInfoMapper.deleteByPrimaryKey(username);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除设备信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除设备信息失败:" + e.toString());
        }

    }
}
