package com.zale.aftersales.service;

import com.zale.aftersales.model.Users;

import java.util.List;

public interface UsersService {

    List<Users> getUsers();


    Users getUsersByUsername(String username);


    boolean addUsers(Users users);


    boolean updateUsers(Users users);


    boolean deleteUsers(String username);
}
