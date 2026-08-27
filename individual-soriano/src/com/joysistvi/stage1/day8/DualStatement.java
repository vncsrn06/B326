package com.joysistvi.stage1.day8;

import java.util.Scanner;

public class DualStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = "winter@gmail.com";
        String password = "winter123";

        boolean isLoggedIn = false;
        do {
            System.out.print("Enter email: ");
            String loginEmail = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPass = scanner.nextLine();

            if (loginEmail.equals(email) && loginPass.equals(password)) {
                System.out.println("Login Successfully!");

                isLoggedIn = true; // stop the while loop
            } else {
                System.out.println("Invalid Username or Password!");
            }
        } while (!isLoggedIn);
    }}