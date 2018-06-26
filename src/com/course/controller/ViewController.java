package com.course.controller;


import com.course.account.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String hello(ModelMap modelMap){
        return "index";
    }

    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    @ResponseBody
    public void verify(@RequestParam String id,@RequestParam String password){
        System.out.println(id+" id" );
        System.out.println(password+" Name" );
    }
}
