package com.joysistvi.stage2.day24;

import java.util.ArrayList;
import java.util.Scanner;

public class Acitivity16Soriano {
    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== TODO MANAGER MENU =====");
            System.out.println("1. Add a task");
            System.out.println("2. View all tasks");
            System.out.println("3. Update a task");
            System.out.println("4. Remove a task");
            System.out.println("5. Clear all tasks");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                System.out.print("Enter a task: ");
                String task = scanner.nextLine();

                tasks.add(task);
                System.out.println("Task added!");

            } else if (choice == 2) {

                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                } else {
                    System.out.println("Tasks:");

                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + ". " + tasks.get(i));
                    }
                }

            } else if (choice == 3) {

                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                } else {
                    System.out.print("Enter task index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    if (index >= 0 && index < tasks.size()) {
                        System.out.print("Enter new task: ");
                        String newTask = scanner.nextLine();

                        tasks.set(index, newTask);
                        System.out.println("Task updated!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                }

            } else if (choice == 4) {

                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                } else {
                    System.out.print("Enter task index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    if (index >= 0 && index < tasks.size()) {
                        tasks.remove(index);
                        System.out.println("Task removed!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                }

            } else if (choice == 5) {

                tasks.clear();
                System.out.println("All tasks cleared!");

            } else if (choice == 0) {

                System.out.println("Exiting Todo Manager. Goodbye!");

            } else {

                System.out.println("Invalid choice.");

            }

        } while (choice != 0);

        scanner.close();
    }
}