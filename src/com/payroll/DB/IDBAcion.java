package com.payroll.DB;

import com.payroll.company.Employee;

import java.util.List;

public interface IDBAcion {
    //增加
    void create(Employee e);
    //删除
    void delete(String idJod);
    //改变
    void update(Employee e);
    //查找列表方式
    List<Employee> findAll();

    //查询员工总数
    int howMany();

    //按照jodNumber查询
    List<Employee> find(String  jodNumber);

}
