package com.payroll.account;


/**
 * 超级管理员类
 *
 * 可以员工的信息进行，增删改查，
 * 比如：增加员工，工资，
 *
 * @author iwe
 * */
public class Manager {
    //

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
