package com.personnelManagement.company;


/**
 * 员工模板类
 *
 * @author iwen
 * */
public class Employee {
    private String id; //身份证号
    private String name;   //姓名
    private String sex;  //性别
    private double salary;  //工资
    private String position;  //职位
    private String department;  //部门
    private String remark;  //备注
    private String jodNumber;  //工号
    private int age;  //年龄


    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getId() {
        return id;
    }
    public String getSex() {
        return sex;
    }
    public double getSalary() {
        return salary;
    }
    public String getPosition() {
        return position;
    }
    public String getDepartment() {
        return department;
    }
    public String getRemark() {
        return remark;
    }
    public String getJodNumber() {
        return jodNumber;
    }
    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public void setJodNumber(String jodNumber) {
        this.jodNumber = jodNumber;
    }

}
