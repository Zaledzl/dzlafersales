package com.zale.aftersales.web;

import com.zale.aftersales.model.UserRoles;
import com.zale.aftersales.service.UserRolesService;
import com.zale.aftersales.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserRolesService userRolesService;

    @GetMapping(value = "/login")
    public String login(Model model){
        System.out.println("已经进入 /login 方法");
        return "login";
    }


    @PostMapping(value = "/userslogin")
    public String usersLogin(Model model,String username,String password){
        System.out.println("已经进入到 /userslogin 方法");
        System.out.println("username和password的值分别是" + username + password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        UserRoles userRoles = new UserRoles();
        userRoles = userRolesService.getUserRolesByUsername(username);
        System.out.println(userRoles.getRolename());

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return  "loginfail";
        }
//        if (subject.hasRole("engineer")){
//            return "hasrole";
//        }
//        return "hasnorole";

       return "index";
    }

    //subject.checkRole("admin");
    //subject.cheRoles("admin","doctor");
    //subject.checkPermission("user:select");
    //subject.checkPermissions("user:select","user:update");
}
