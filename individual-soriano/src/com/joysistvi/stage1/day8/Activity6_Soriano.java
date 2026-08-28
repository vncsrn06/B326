package com.joysistvi.stage1.day8;

import java.util.Scanner;

public class Activity6_Soriano {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String email = "vnc123@gmail.com";
        String password = "vnc123";

        int maxAttempts = 3;
        boolean isLoggedIn = false;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {

            System.out.println("\nAttempt " + attempt + " of " + maxAttempts);

            System.out.print("Email: ");
            String loginEmail = input.nextLine();

            System.out.print("Password: ");
            String loginPassword = input.nextLine();

            if (loginEmail.equals(email) &&
                    loginPassword.equals(password)) {

                System.out.println("Login Successful");

                isLoggedIn = true;
                break;
            }

            else if (!loginEmail.equals(email) &&
                    !loginPassword.equals(password)) {

                System.out.println("Invalid Email and Password");

            }

            else if (!loginEmail.equals(email)) {

                System.out.println("Invalid Email");

            }

            else {

                System.out.println("Invalid Password");
            }
        }

        if (!isLoggedIn) {
            System.out.println("\nMaximum attempts reached.");
            System.out.println("Account locked.");
        }

    }
}