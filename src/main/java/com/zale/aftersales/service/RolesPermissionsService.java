package com.zale.aftersales.service;

import com.zale.aftersales.model.RolesPermissions;
import com.zale.aftersales.model.Users;

import java.util.List;

public interface RolesPermissionsService {
    List<RolesPermissions> getRolesPermissions();


    RolesPermissions getRolesPermissionsByUsername(String username);


    boolean addRolesPermissions(RolesPermissions rolesPermissions);


    boolean updateRolesPermissions(RolesPermissions rolesPermissions);


    boolean deleteRolesPermissions(String username);
}
