package com.zale.aftersales.mapper;

import com.zale.aftersales.model.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    int deleteByPrimaryKey(String username);

    int insert(Users record);

    Users selectByPrimaryKey(String username);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);
}