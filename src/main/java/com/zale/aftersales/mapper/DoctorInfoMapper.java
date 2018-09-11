package com.zale.aftersales.mapper;

import com.zale.aftersales.model.DoctorInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorInfoMapper {
    int deleteByPrimaryKey(String doctorUsername);

    int insert(DoctorInfo record);

    DoctorInfo selectByPrimaryKey(String doctorUsername);

    List<DoctorInfo> selectAll();

    int updateByPrimaryKey(DoctorInfo record);
}