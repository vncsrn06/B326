package com.joysistvi.stage1.day7;

import java.util.Scanner;

public class NestedIfStatement {
    public static void main(String[] args) {
// [Section] Syntax of Nested If Statement

        /*
            if () { outer if
                if () { inner if
                    if () {

                    }
                } else {
                    if () {

                    }
                }
            } else {
                if () {

                }
            }
         */

        // Age Categorizer
        /* Requirements
            Age: 0 - 2 Category: Baby
            Age: 3 - 12 Category: Child
            Age: 13 - 19 Category: Teenager

         */
        Scanner sc=new Scanner(System.in);

        System.out.println("== -Age Categorizer ==");
        System.out.print("Enter Your Age: ");
        int age = sc.nextInt();

        // Code Minization for getting the Range
        // Validation

        if (age < 0 || age > 100) {
            System.out.println("Invalid Age");
        }
            if (age <= 2) {
                System.out.println("Category: Baby");
            } else if (age <= 12) {
                System.out.println("Category: Child");
            } else if  (age <= 18) {
                System.out.println("Category: Teenager");
            } else {
                System.out.println("Category: Invalid Choice");


            String category = age < 0 ? "Invalid Input" :
                    age <= 2 ? "Category: Baby" :
                            age <= 12 ? "Category: Child" :
                                    age <= 19 ? "Category: Teenager" :
                                            "Invalid Input";

            System.out.println(category);

            /*
            // Early Exit
        if (!(age >=0 && age <= 120)){
            System.out.println("Invalid Age");
            return;
        }

        if (age <= 2) { // 0 - 2
            System.out.println("Category: Baby");
        } else if (age <= 12) { // 3 - 12
            System.out.println("Category: Child");
        } else if ( age <= 19) {
            System.out.println("Category: Teenager");
        } else {
            System.out.println("Invalid Input");
             */
        }
    }
}
