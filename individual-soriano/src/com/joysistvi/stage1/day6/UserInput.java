package com.joysistvi.stage1.day6;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        // Create an object of Scanner / Instantiation
        // [Syntax] ClassName object = new Constructor(Argument)
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter your name:");
        String name=sc.nextLine();

        System.out.print("Enter your age:");
        int age =  sc.nextInt();

        System.out.println("Name: "  + name);
        System.out.println("Age: "  + age);
    }
}

/*
 == Main Menu ==
  [1] Start game
  [2] Load game
  [3]
  [4]
 */
