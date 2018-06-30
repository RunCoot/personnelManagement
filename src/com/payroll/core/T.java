package com.payroll.core;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {
    @Test
    public void a(){
        ApplicationContext a= new ClassPathXmlApplicationContext("Beans.xml");
        Verify v = (Verify) a.getBean("verify");
        v.verify("ajax","3424");

        System.out.println(v);


        Verify v1 = (Verify) a.getBean("verify");
        System.out.println(v1);
    }
}
