package com.zale.aftersales.service.Impl;

import com.zale.aftersales.mapper.DoctorInfoMapper;
import com.zale.aftersales.model.DoctorInfo;
import com.zale.aftersales.service.DoctorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorInfoServiceImpl implements DoctorInfoService {

    @Autowired
    private DoctorInfoMapper doctorInfoMapper;

    @Override
    public List<DoctorInfo> getDoctorInfo() {
        return doctorInfoMapper.selectAll();
    }

    @Override
    public DoctorInfo getDoctorInfoByUsername(String username) {
        return doctorInfoMapper.selectByPrimaryKey(username);
    }

    @Transactional
    @Override
    public boolean addDoctorInfo(DoctorInfo doctorInfo) {
        if (doctorInfo.getDoctorUsername() != null) {
            try {
                int effectedNum = doctorInfoMapper.insert(doctorInfo);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("添加医生信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加医生信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户医生不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean updateDoctorInfo(DoctorInfo doctorInfo) {
        if (doctorInfo.getDoctorUsername() != null) {
            try {
                int effectedNum = doctorInfoMapper.updateByPrimaryKey(doctorInfo);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("更新医生信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新医生信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户医生不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteDoctorInfo(String username) {
        try {
            // 删除用户信息
            int effectedNum = doctorInfoMapper.deleteByPrimaryKey(username);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除医生信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除医生信息失败:" + e.toString());
        }


    }
}
