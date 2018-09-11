package com.zale.aftersales.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class CompanyController {

    @GetMapping(value = "/companyfunction")
    public String companyFunction(Model model){
        System.out.println("已经进入到companyfunction");
        return "companyfunction";
    }
}
