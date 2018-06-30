package com.personnelManagement.controller;


import com.personnelManagement.DB.EmployeeJDBCTemplate;
import com.personnelManagement.company.Employee;
import com.personnelManagement.core.Verify;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class ViewController {
    private ApplicationContext appVerify = new ClassPathXmlApplicationContext("Beans.xml");
    private Verify verify = (Verify) appVerify.getBean("verify");
    private EmployeeJDBCTemplate empTemplate = (EmployeeJDBCTemplate) appVerify.getBean("employeeJDBCTemplate");
//    private boolean isFlash = true;
    private String iAmWho;




    /**
     * 登录界面
     * */
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String hello(ModelMap modelMap){
        if (verify.isVerify()) return "redirect:/employee/manager";//已经登录，就不再显示登录界面
        return "index";
    }

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String retHello(){
        return "redirect:/login";
    }


    /**
     *
     * 登录成功返回1，失败返回0,返回2为已经登录，无需在登录
     */
    @ResponseBody
    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    public String verify(@RequestParam String id,@RequestParam String password){
        if (verify.isVerify()) return "2";//检测是否已经登录成功，成功则不再重复登录,并且返回2
        verify.verify(id,password);
        if (verify.isVerify()) {
            iAmWho = id;
            return "1";
        }
        else return  "0";
    }

    /**
     * 管理界面
     * */
    @RequestMapping(value = "/employee/manager",method = RequestMethod.GET)
    public String manager(ModelMap modelMap){
        if (!verify.isVerify()) return "redirect:/login";
        modelMap.addAttribute("employee_amount",empTemplate.howMany());
        modelMap.addAttribute("ianwho",iAmWho);
        return "management";
    }


    /**
     * 退出登录
     * */
    @RequestMapping(value = "/back",method = RequestMethod.GET)
    public String back(){
        if (verify.isVerify()){
            verify.setVerify(false);
        }
        return  "redirect:/login";
    }

    /**
     * 刷新获取员工数量
     * */
    @ResponseBody
    @RequestMapping(value = "/get-amount",method = RequestMethod.POST)
    public Integer getAmount(){
        Integer inte = empTemplate.howMany();
        return  inte;
    }


    /*
    * 增加新的员工
    * **/
    @ResponseBody
    @RequestMapping(value = "/add_employee",method = RequestMethod.POST)
    public String newEmployee(@RequestBody  Employee emp){
        empTemplate.create(emp);

        return "1";
    }

    /**
     *
     * 刷新员工列表
     *
     * */
    @ResponseBody
    @RequestMapping(value = "/flash_table",method = RequestMethod.POST)
    public List<Employee> flashTable(){
        List<Employee> le = null;

        le = empTemplate.findAll();

        return le;
    }



    /**
     * 按照jodNumber查询信息
     * */
    @ResponseBody
    @RequestMapping(value = "/flash_obj",method = RequestMethod.POST)
    public List<Employee> findObj(@RequestBody String jodNumber){
//        System.out.println(jodNumber);
        String target = jodNumber.replace('"',' ');
        target = target.trim();
        List<Employee> le = null;
//        System.out.println(jodNumber);
        le = empTemplate.find(target);

        return le;
    }

    @ResponseBody
    @RequestMapping(value = "/updata_obj",method = RequestMethod.POST)
    public String updateObj(@RequestBody Employee e){

        empTemplate.update(e);

        return "1";
    }


    @ResponseBody
    @RequestMapping(value = "/del_obj",method = RequestMethod.POST)
    public String delObj(@RequestBody String jodNumber){
        String target = jodNumber.replace('"',' ');
        target = target.trim();
//        System.out.println(jodNumber+" : "+target);
        empTemplate.delete(target);

        return "1";
    }























}
