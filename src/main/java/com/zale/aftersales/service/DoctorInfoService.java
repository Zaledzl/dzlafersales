package com.zale.aftersales.service;

import com.zale.aftersales.model.DoctorInfo;
import com.zale.aftersales.model.Users;

import java.util.List;

public interface DoctorInfoService {

    List<DoctorInfo> getDoctorInfo();


    DoctorInfo getDoctorInfoByUsername(String username);


    boolean addDoctorInfo(DoctorInfo doctorInfo);


    boolean updateDoctorInfo(DoctorInfo doctorInfo);


    boolean deleteDoctorInfo(String username);

}
