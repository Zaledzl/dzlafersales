package com.zale.aftersales.service.Impl;

import com.zale.aftersales.mapper.UserRolesMapper;
import com.zale.aftersales.mapper.UsersMapper;
import com.zale.aftersales.model.UserRoles;
import com.zale.aftersales.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Override
    public List<UserRoles> getUserRoles() {
        return userRolesMapper.selectAll();
    }

    @Override
    public UserRoles getUserRolesByUsername(String username) {
        return userRolesMapper.selectByPrimaryKey(username);
    }

    @Transactional
    @Override
    public boolean addUserRoles(UserRoles userRoles) {
        if (userRoles.getUsername() != null) {
            try {
                int effectedNum = userRolesMapper.insert(userRoles);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("添加用户-角色信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加用户-角色信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户-角色信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean updateUserRoles(UserRoles userRoles) {

        if (userRoles.getUsername() != null) {
            try {
                int effectedNum = userRolesMapper.updateByPrimaryKey(userRoles);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("更新用户-角色信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新用户-角色信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户-角色信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteUserRoles(String username) {

        try {
            // 删除用户信息
            int effectedNum = userRolesMapper.deleteByPrimaryKey(username);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除用户-角色信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除用户-角色信息失败:" + e.toString());
        }
    }

}
