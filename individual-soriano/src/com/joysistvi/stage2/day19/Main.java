package com.joysistvi.stage2.day19;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("*  USER ACCOUNT INFORMATION  *");
        System.out.println("******************************");
        System.out.println("");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Middle Name: ");
        String middleName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        String email;

        while (true) {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();

            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                break;
            }

            System.out.println("Invalid email format. Please try again.");
        }

        String password;

        while (true) {
            System.out.print("Enter Password (at least 8 characters): ");
            password = scanner.nextLine();

            if (password.length() >= 8) {
                break;
            }

            System.out.println("Password must be at least 8 characters.");
        }
        Account user = new Account(
                firstName,
                middleName,
                lastName,
                address,
                email,
                password
        );

        System.out.println("--- User Account Created ---");
        System.out.println("Full Name: "
                + user.getFirstName() + " "
                + user.getMiddleName() + " "
                + user.getLastName());

        System.out.println("Email: " + user.getEmail());
        System.out.println("Address: " + user.getAddress());

        scanner.close();
    }
}
