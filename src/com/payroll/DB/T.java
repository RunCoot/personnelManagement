package com.payroll.DB;

import com.payroll.account.Manager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {
    @Test
    public void t(){
        ApplicationContext a = new ClassPathXmlApplicationContext("/Beans.xml");
        CompanyManager c = (CompanyManager) a.getBean("companyManager");
        Manager m = c.queryUser("iwena");
        System.out.println(m.getUserName()+" "+m.getPassword());




    }
}
