package com.joysistvi.stage1.day7;

import java.util.Scanner;

public class Activity5_Soriano {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        long correctID = 10006381930L;
        String correctPIN = "1104";

        System.out.println(" === LOGIN MARIBANK === ");

        System.out.println("ID: " + correctID);

        System.out.print("PIN: ");
        String enteredPIN=sc.nextLine();

            if (enteredPIN.equals(correctPIN)) {
                System.out.println("LOGIN SUCCESS");
                System.out.println("WELCOME TO MARIBANK");


        double balance = 5000.00;
        int choice;
        double depositAmount;
        double withdrawAmount;

        do {
            System.out.println("== MARIBANK MENU == ");
            System.out.println("1 - Check Balance");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.printf("Current balance: $%.1f%n", balance);
                    break;

                case 2:
                    System.out.printf("Enter deposit amount: ");
                    depositAmount = sc.nextDouble();
                    if (depositAmount > 0) {
                        balance = balance + depositAmount;
                        System.out.printf("Deposit Successful!%n New Balance: $%.1f%n" , balance);
                    } else {
                        System.out.println("Error");
                    }

                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    withdrawAmount = sc.nextDouble();
                    if (withdrawAmount > 0) {
                        if (withdrawAmount <= balance) {
                            balance = balance - withdrawAmount;
                            System.out.printf("Withdrawal Successful!%n New Balance: $%.1f%n" , balance);
                        } else {
                            System.out.println("Insufficient Balance");
                        }
                    } else {
                        System.out.println("Error: Withdrawal Amount must be greater than 0");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using MARIBANK");
                    System.out.println("Goodbye!");

                    break;
                default:
                    System.out.println("Invalid choice");
            }
            } while (choice != 4);
        } else{
                System.out.println("Incorrect PIN.");
            }
    }
}

