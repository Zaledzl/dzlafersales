package com.zale.aftersales.mapper;

import com.zale.aftersales.model.UserRoles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRolesMapper {
    int deleteByPrimaryKey(String username);

    int insert(UserRoles record);

    UserRoles selectByPrimaryKey(String username);

    List<UserRoles> selectAll();

    int updateByPrimaryKey(UserRoles record);
}