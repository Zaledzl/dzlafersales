package com.zale.aftersales.service.Impl;

import com.zale.aftersales.mapper.EngineerInfoMapper;
import com.zale.aftersales.model.EngineerInfo;
import com.zale.aftersales.service.EngineerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EngineerInfoServiceImpl implements EngineerInfoService {

    @Autowired
    private EngineerInfoMapper engineerInfoMapper;

    @Override
    public List<EngineerInfo> getEngineerInfo() {
        return engineerInfoMapper.selectAll();
    }

    @Override
    public EngineerInfo getEngineerInfoByUsername(String username) {
        return engineerInfoMapper.selectByPrimaryKey(username);
    }

    @Transactional
    @Override
    public boolean addEngineerInfo(EngineerInfo engineerInfo) {
        if (engineerInfo.getEngineerUsername() != null) {
            try {
                int effectedNum = engineerInfoMapper.insert(engineerInfo);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("添加工程师信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加工程师信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("工程师信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean updateEngineerInfo(EngineerInfo engineerInfo) {
        if (engineerInfo.getEngineerUsername() != null) {
            try {
                int effectedNum = engineerInfoMapper.updateByPrimaryKey(engineerInfo);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("更新工程师信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新工程师信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("工程师信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteEngineerInfo(String username) {
        try {
            // 删除用户信息
            int effectedNum = engineerInfoMapper.deleteByPrimaryKey(username);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除工程师信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除工程师信息失败:" + e.toString());
        }

    }

}
