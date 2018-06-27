package com.payroll.core;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {
    @Test
    public void a(){
        ApplicationContext a= new ClassPathXmlApplicationContext("Beans.xml");

//        a.getBean("companyManager");
        Verify v = (Verify) a.getBean("verify");
        v.verify("iwen1","fe43");

        System.out.println(v.isVerify());
    }
}
