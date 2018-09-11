package com.zale.aftersales.service.Impl;

import com.zale.aftersales.mapper.CompanyInfoMapper;
import com.zale.aftersales.model.CompanyInfo;
import com.zale.aftersales.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    @Override
    public List<CompanyInfo> getCompanyInfo() {
        return companyInfoMapper.selectAll();
    }

    @Override
    public CompanyInfo getCompanyInfoByUsername(String username) {
        return companyInfoMapper.selectByPrimaryKey(username);
    }

    @Transactional
    @Override
    public boolean addCompanyInfo(CompanyInfo companyInfo) {
        if (companyInfo.getCompanyUsername() != null) {
            try {
                int effectedNum = companyInfoMapper.insert(companyInfo);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("添加公司用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加公司用户信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("公司用户信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean updateCompanyInfo(CompanyInfo companyInfo) {
        if (companyInfo.getCompanyUsername() != null) {
            try {
                int effectedNum = companyInfoMapper.updateByPrimaryKey(companyInfo);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("更新公司用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新公司用户信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("公司用户信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteCompanyInfo(String username) {
        try {
            // 删除用户信息
            int effectedNum = companyInfoMapper.deleteByPrimaryKey(username);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除公司用户信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除公司用户信息失败:" + e.toString());
        }

    }
}
