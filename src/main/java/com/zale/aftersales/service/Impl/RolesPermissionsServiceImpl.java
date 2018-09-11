package com.zale.aftersales.service.Impl;

import com.zale.aftersales.mapper.EquipmentInfoMapper;
import com.zale.aftersales.mapper.RolesPermissionsMapper;
import com.zale.aftersales.model.RolesPermissions;
import com.zale.aftersales.service.RolesPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolesPermissionsServiceImpl implements RolesPermissionsService {

    @Autowired
    private RolesPermissionsMapper rolesPermissionsMapper;

    @Override
    public List<RolesPermissions> getRolesPermissions() {
        return rolesPermissionsMapper.selectAll();
    }

    @Override
    public RolesPermissions getRolesPermissionsByUsername(String username) {
        return rolesPermissionsMapper.selectByPrimaryKey(username);
    }

    @Transactional
    @Override
    public boolean addRolesPermissions(RolesPermissions rolesPermissions) {
        if (rolesPermissions.getRolename() != null) {
            try {
                int effectedNum = rolesPermissionsMapper.insert(rolesPermissions);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("添加角色-权限信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加角色-权限信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("角色-权限信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean updateRolesPermissions(RolesPermissions rolesPermissions) {

        if (rolesPermissions.getRolename() != null) {
            try {
                int effectedNum = rolesPermissionsMapper.updateByPrimaryKey(rolesPermissions);

                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("更新角色-权限信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新角色-权限信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("角色-权限信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteRolesPermissions(String username) {
        try {
            // 删除用户信息
            int effectedNum = rolesPermissionsMapper.deleteByPrimaryKey(username);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除角色-权限信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除角色-权限信息失败:" + e.toString());
        }

    }
}
