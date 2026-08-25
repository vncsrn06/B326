package com.joysistvi.stage1.day6;

import java.util.Scanner;

public class Activity4_If_Soriano {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("=== Game Menu === ");
        System.out.println("1. Start Game");
        System.out.println("2. Load Game");
        System.out.println("3. Settings");
        System.out.println("4. Exit");

        System.out.print("Enter your choice (1-4) : ");
        int choice=sc.nextInt();

        if(choice == 1){
            System.out.println("You selected Option 1: Start Game");
        } else if(choice == 2){
            System.out.println("You selected Option 2: Load Game");
        } else if(choice == 3){
            System.out.println("You selected Option 3: Settings");
        } else if(choice == 4){
            System.out.println("You selected Option 4: Exit");
        } else {
            System.out.println("Invalid Choice, Please Try Again");
        }
    }
}
