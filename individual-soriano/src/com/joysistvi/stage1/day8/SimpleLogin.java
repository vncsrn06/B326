package com.joysistvi.stage1.day8;

import java.util.Scanner;

public class SimpleLogin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String email = "winter@gmail.com";
        String password = "winter123";

        System.out.println("Enter email: ");
        String loginEmail = in.nextLine();
        System.out.println("Enter password: ");
        String loginPassword = in.nextLine();

        if (loginEmail.equals(email) && loginPassword.equals(password)) {
            System.out.println("Login Successful");

        }
    }
}
