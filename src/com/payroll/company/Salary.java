package com.payroll.company;

public class Salary {
    //基本工工资
    private double baseSalary = 0;
    //奖金
    private double bonus = 0;
    //考勤
    private double checkingIn = 0;
    //保险
    private double insurance = 0;
    //税
    private double tax = 0;
    //实发工资
    private double realWages = 0;

    public double calculateSalary(){
        this.realWages = baseSalary+bonus+checkingIn+insurance+tax;
        return this.realWages;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setCheckingIn(double checkingIn) {
        this.checkingIn = checkingIn;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "baseSalary=" + baseSalary +
                ", bonus=" + bonus +
                ", checkingIn=" + checkingIn +
                ", insurance=" + insurance +
                ", tax=" + tax +
                ", realWages=" + realWages +
                '}';
    }
}
