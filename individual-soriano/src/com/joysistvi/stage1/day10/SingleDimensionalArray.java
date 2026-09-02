package com.joysistvi.stage1.day10;

import java.util.Scanner;

public class SingleDimensionalArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Syntax -> Declare  an array with  a specified  size only
        // DataType object = new DataType[5];

        int[] evenNumbers = new int[5];

        System.out.println("Enter the first five even numbers: ");

        for  (int i = 0; i < evenNumbers.length; i++) {

            evenNumbers[i] = input.nextInt();
        }

        System.out.println("\nTrasvering even numbers: ");
        for(int evenNumber : evenNumbers) {
            System.out.println(evenNumber + " ");
        }




        //evenNumbers[0] = 2;
        //evenNumbers[1] = 4;
        //evenNumbers[2] = 6;
        //evenNumbers[3] = 8;
        //evenNumbers[4] = 10;



        //String[] cars = {"BMW", "SUV", "FERRARI", "SEDAN", "MERCEDES"};
        // INVOKE AN ELEMENT FROM AN ARRAY
        //System.out.println(cars[4]);
//
        //System.out.println(cars[cars.length-1]);
//
        //System.out.println(cars.length);
//
        //for (int i = 0; i < cars.length; i++) {
        //System.out.println(cars[i]);
        //for (String car : cars) {
            //System.out.println(car);
        }


    }

