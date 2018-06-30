package com.personnelManagement.company;

public class Employee {
    private String id;
    private String name;
    private String sex;
    private double salary;
    private String position;
    private String department;
    private String remark;
    private String jodNumber;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




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
