package com.joysistvi.stage1.day10;

import java.util.Scanner;

public class Activity8_Soriano {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] integers = new int[5];

        int sum = 0;


        System.out.println("Enter 5 numbers: ");
        for  (int i = 0; i < integers.length; i++) {

            System.out.print("Enter Number " + (i + 1) + ": ");
            integers[i] = input.nextInt();

            sum += integers[i];
        }

        System.out.println("\nYou Entered: ");
        for (int integer : integers) {
            System.out.println("Index: " + integer + " ");

        }
        double average = (double) sum / (double)integers.length;

        int highest = integers[0];
        int lowest = integers[0];

        for (int i = 0; i < integers.length; i++) {
            if (integers[i] > highest) {
                highest = integers[i];
            }

            if (integers[i] < lowest) {
                lowest = integers[i];
            }
        }

        System.out.println("\nSum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Highest = " + highest);
        System.out.println("Lowest = " + lowest);
        }


    }

