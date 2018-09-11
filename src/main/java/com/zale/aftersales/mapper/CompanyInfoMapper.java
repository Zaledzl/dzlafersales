package com.zale.aftersales.mapper;

import com.zale.aftersales.model.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyInfoMapper {
    int deleteByPrimaryKey(String companyUsername);

    int insert(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(String companyUsername);

    List<CompanyInfo> selectAll();

    int updateByPrimaryKey(CompanyInfo record);
}