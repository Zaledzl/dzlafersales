package com.zale.aftersales.service;

import com.zale.aftersales.model.CompanyInfo;
import com.zale.aftersales.model.Users;

import java.util.List;

public interface CompanyInfoService {

    List<CompanyInfo> getCompanyInfo();


    CompanyInfo getCompanyInfoByUsername(String username);


    boolean addCompanyInfo(CompanyInfo companyInfo);


    boolean updateCompanyInfo(CompanyInfo companyInfo);


    boolean deleteCompanyInfo(String username);

}
