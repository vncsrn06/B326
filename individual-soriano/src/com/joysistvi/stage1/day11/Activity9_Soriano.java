package com.joysistvi.stage1.day11;

import java.util.Scanner;

public class Activity9_Soriano {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("        Average Calculator");
        System.out.println("=================================");

        System.out.print("Enter number of students: ");
        int students = scan.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjects = scan.nextInt();
        scan.nextLine();

        String[] subjectNames = new String[subjects];
        System.out.println("\nEnter subjects names: ");

        for (int i = 0; i < subjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            subjectNames[i] = scan.next();
        }
        String[] studentNames = new String[students];
        double[][] grades = new double[students][subjects];
        double[] averages = new double[students];

        for (int i = 0; i < students; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            studentNames[i] = scan.next();

            double total = 0;
            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter grade for " + subjectNames[j] + ": ");
                grades[i][j] = scan.nextDouble();

                total += grades[i][j];
            }
            averages[i] = total /  subjects;

            scan.nextLine();

        }
        System.out.println("=================================");
        System.out.println("         GRADES REPORT");
        System.out.println("=================================");

        System.out.printf("%-20s", "Student Name");

        for (String subject : subjectNames) {
            System.out.printf("%-11s", subject);
        }

        System.out.printf("%-10s%n", "Average");

        System.out.println("------------------------------------------------");
        for (int i = 0; i < students; i++) {

            System.out.printf("%-20s", studentNames[i]);
            for (int j = 0; j < subjects; j++) {
                System.out.printf("%-11.0f", grades[i][j]);
            }
            System.out.printf("%-10.2f%n", averages[i]);
        }
        System.out.println("====================================");
    }
}
