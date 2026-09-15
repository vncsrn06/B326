package com.joysistvi.stage2.day22;

public abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double computeSalary();

    public abstract String getEmployeeType();

    public abstract double computeDeductions();

    // Concrete method - built on top of the abstract methods above
    public double computeNetSalary() {
        return computeSalary() - computeDeductions();
    }

    public void printPayslip() {
        System.out.println(name + "'s gross salary: " + computeSalary()
                + " (" + getEmployeeType() + ")");
        System.out.println("Deductions: " + computeDeductions());
        System.out.println("Net salary: " + computeNetSalary());
    }
}

