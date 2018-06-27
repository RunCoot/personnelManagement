package com.payroll.DB;

import com.payroll.company.Employee;

import java.util.List;

public interface IDBAcion {
    //增加
    public void create(Employee e);
    //删除
    void delete(Integer idJod);
    //改变
    void update(Employee e);
    //查找列表方式
    List<Employee> findAll();

}
