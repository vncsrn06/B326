package com.joysistvi.stage2.day21;

public class ManagerEmployee extends Employee {

    public ManagerEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double computeSalary() {
        return baseSalary + 5000;
    }
}

