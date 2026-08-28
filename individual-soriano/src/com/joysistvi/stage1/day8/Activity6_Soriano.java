package com.joysistvi.stage1.day8;

import java.util.Scanner;

public class Activity6_Soriano {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String Email = "vnc123@gmail.com";
        String Passwd = "vnc123";

        int maxAttempts = 3;
        boolean isLoggedin = false;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {

            System.out.println("\nAttempt " + attempt + "of " + maxAttempts);

            System.out.print("Email: ");
            String loginEmail = input.nextLine();

            System.out.print("Password: ");
            String loginPass = input.nextLine();

            if (loginEmail.equals(Email) && loginPass.equals(Passwd)) {
                System.out.println("Login Successful");

                isLoggedin = true;
                break;
            }
            else if (!loginEmail.equals(Email) && !loginPass.equals(Passwd)) {
                System.out.println("Invalid Email and Password");

            }

            else if  (!loginEmail.equals(Email)) {
                System.out.println("Invalid Email ");

            }
            else { System.out.println("Invalid Password");
            }
        }
        if (!isLoggedin) {
            System.out.println("\nMaximum attempts reached");
        }
    }
}
