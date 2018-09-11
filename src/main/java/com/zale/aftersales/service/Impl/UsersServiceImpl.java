package com.zale.aftersales.service.Impl;

import com.zale.aftersales.mapper.UsersMapper;
import com.zale.aftersales.model.Users;
import com.zale.aftersales.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> getUsers() {
        return usersMapper.selectAll();
    }

    @Override
    public Users getUsersByUsername(String username) {
        return usersMapper.selectByPrimaryKey(username);
    }

    @Transactional
    @Override
    public boolean addUsers(Users users) {

        if (users.getUsername() != null) {
            try {
                int effectedNum = usersMapper.insert(users);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("添加用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加用户信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean updateUsers(Users users) {
        if (users.getUsername() != null) {
            try {
                // 更新区域信息
                int effectedNum = usersMapper.updateByPrimaryKey(users);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新用户信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteUsers(String username) {
        try {
            // 删除用户信息
            int effectedNum = usersMapper.deleteByPrimaryKey(username);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除用户信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除用户信息失败:" + e.toString());
        }
    }
    }
