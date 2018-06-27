package com.payroll.company;

public class Employee {
    private int id;
    private String name;
    private String sex;
    private double salary;
    private String position;
    private String department;
    private String remark;
    private int jodNumber;


    public int getId() {
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

    public int getJodNumber() {
        return jodNumber;
    }





    public String getName() {
        return name;
    }

    public void setId(int id) {
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

    public void setJodNumber(int jodNumber) {
        this.jodNumber = jodNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", remark='" + remark + '\'' +
                ", jodNumber=" + jodNumber +
                '}';
    }
}
