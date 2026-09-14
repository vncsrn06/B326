package com.joysistvi.stage2.day21;

public class RegularEmployee extends Employee {

    public RegularEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double computeSalary() {
        return baseSalary + 1000;
    }
}
