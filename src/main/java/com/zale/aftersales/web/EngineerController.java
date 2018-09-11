package com.zale.aftersales.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class EngineerController {


    @GetMapping(value = "/engineerfunction")
    public String companyFunction(Model model){

        Subject subject = SecurityUtils.getSubject();
        System.out.println("已经进入工程师功能页面");
        return "engineerfunction";
    }

}
