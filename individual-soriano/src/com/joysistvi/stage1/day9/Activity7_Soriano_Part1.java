package com.joysistvi.stage1.day9;

import java.util.Scanner;

public class Activity7_Soriano_Part1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Multiplication Table: ");
        int num = input.nextInt();

        System.out.println("\nMultiplication Table of " + num);

        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + num * i);
        }
    }
}
