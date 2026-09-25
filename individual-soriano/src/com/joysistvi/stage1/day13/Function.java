package com.joysistvi.stage1.day13;

import java.util.Scanner;

public class Function {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int firstNum = sc.nextInt();
        System.out.print("Enter second number: ");
        int secondNum = sc.nextInt();

        System.out.println(max(firstNum, secondNum));
    }

    // parameters and arguments
    public static int max(int a, int b) {

        return Math.max(a,b);
    }

}