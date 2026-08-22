package com.joysistvi.stage1.day4;

public class Activity2_Soriano {
    public static void main(String[] args) {
        double income = 50000;
        double foodAllowance = 15000;
        double transportation = 2500;
        double rent = 4500;
        double utilityBill = 3500;

        double foodPercentage = (foodAllowance / income) * 100;
        double transportationPercentage = (transportation / income) * 100;
        double rentPercentage = (rent / income) * 100;
        double utilityPercentage = (utilityBill / income) * 100;

        double remainingBalance = income - foodAllowance - transportation - rent - utilityBill;

        System.out.println("Income: " + (int) income);
        System.out.printf("Food Allowance: %.1f %%%n", foodPercentage);
        System.out.printf("Transportation: %.1f %%%n", transportationPercentage);
        System.out.printf("Rent: %.1f %%%n", rentPercentage);
        System.out.printf("Utility Bill: %.1f %%%n", utilityPercentage);

        System.out.println("Remaining Balance: " + (int) remainingBalance);
    }
}
