package com.zale.aftersales.service;

import com.zale.aftersales.model.EngineerInfo;
import com.zale.aftersales.model.Users;

import java.util.List;

public interface EngineerInfoService {

    List<EngineerInfo> getEngineerInfo();


    EngineerInfo getEngineerInfoByUsername(String username);


    boolean addEngineerInfo(EngineerInfo engineerInfo);


    boolean updateEngineerInfo(EngineerInfo engineerInfo);


    boolean deleteEngineerInfo(String username);

}
