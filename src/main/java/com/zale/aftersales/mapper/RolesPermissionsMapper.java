package com.zale.aftersales.mapper;

import com.zale.aftersales.model.RolesPermissions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolesPermissionsMapper {
    int deleteByPrimaryKey(String rolename);

    int insert(RolesPermissions record);

    RolesPermissions selectByPrimaryKey(String rolename);

    List<RolesPermissions> selectAll();

    int updateByPrimaryKey(RolesPermissions record);
}