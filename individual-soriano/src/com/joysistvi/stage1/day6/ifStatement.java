package com.joysistvi.stage1.day6;

import java.util.Scanner;

public class ifStatement {
    public static void main(String[] args) {

        // [Section] If-else statement
        /*
            Syntax:
            if (condition) {
                // if block
            } else {
                // else block
            }
        */

        float temp = 36.0f;
        String result = "";

        if (temp > 36.6f) {
            result = "Fever";
        } else {
            result = "Normal Temp";
        }
        System.out.println(result);


        int day = 2;

        if (day == 1) {
            System.out.println("Monday");
        } else if (day == 2) {
            System.out.println("Tuesday");
        } else if (day == 3) {
            System.out.println("Wednesday");
        } else if (day == 4) {
                System.out.println("Thursday");
        } else if (day == 5) {
                System.out.println("Friday");
        } else if (day == 6) {
                System.out.println("Saturday");
        } else if  (day == 7) {
            System.out.println("Sunday");
        } else {
            System.out.println("Invalid Output");
        }
    }
}
