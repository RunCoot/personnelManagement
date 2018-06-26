package com.course.controller;


import com.course.account.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

        return  "1";
    }


}
