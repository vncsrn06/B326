package com.joysistvi.stage1.day7;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter First Number: ");
        double num1=sc.nextDouble();

        System.out.print("Enter Operator ( +, -, *, /): ");
        char op=sc.next().charAt(0);

        System.out.print("Enter Second Number: ");
        double num2=sc.nextDouble();


        switch (op) {
            case '+':
                System.out.println("Result:" + (num1 + num2));
                break;
            case '-':
                System.out.println("Result:" + (num1 - num2));
                break;
            case '*':
                System.out.println("Result:" + (num1 * num2));
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero");
                } else {
                    System.out.println("Result:" + (num1 / num2));

                }
                break;
            default:
                System.out.println("Invalid Input");
        }

    }
}
