package com.zale.aftersales.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class DoctorController {

    @GetMapping(value = "/doctorfunction")
    public String companyFunction(Model model){
        return "doctorfunction";
    }

}
