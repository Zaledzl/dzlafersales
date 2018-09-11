package com.zale.aftersales.mapper;

import com.zale.aftersales.model.EngineerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EngineerInfoMapper {
    int deleteByPrimaryKey(String engineerUsername);

    int insert(EngineerInfo record);

    EngineerInfo selectByPrimaryKey(String engineerUsername);

    List<EngineerInfo> selectAll();

    int updateByPrimaryKey(EngineerInfo record);
}