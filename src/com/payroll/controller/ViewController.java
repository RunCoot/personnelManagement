package com.payroll.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class ViewController {

    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String hello(ModelMap modelMap){
        return "index";
    }



    //登录成功返回1，失败返回0
    @ResponseBody
    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    public String verify(@RequestParam String id,@RequestParam String password){
        System.out.println("id"+id+" passwword"+password);
        return  "1";
    }


}
