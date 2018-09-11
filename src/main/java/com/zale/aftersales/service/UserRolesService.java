package com.zale.aftersales.service;

import com.zale.aftersales.model.UserRoles;
import com.zale.aftersales.model.Users;

import java.util.List;

public interface UserRolesService {

    List<UserRoles> getUserRoles();


    UserRoles getUserRolesByUsername(String username);


    boolean addUserRoles(UserRoles userRoles);


    boolean updateUserRoles(UserRoles userRoles);


    boolean deleteUserRoles(String username);
}
