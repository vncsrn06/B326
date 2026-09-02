package com.joysistvi.stage1.day11;

import java.util.Scanner;

public class MultiDimensionalArray {

    public static void main(String[] args) {

      //  int [][] numbers = {
            //   0  1  2
             //   {1, 2, 3}, // 0
             //   {4, 5, 6}, // 1
              //  {7, 8, 9} // 2
       // };

       // System.out.println(numbers.length);
       // System.out.println(numbers[0].length);

       // System.out.println(numbers[0][1]);

        // [Section] Multi-dimensional array using Scanner
        Scanner scan = new Scanner(System.in);

        String[][] planets = new String[2][4];

        for (int i = 0; i < planets.length; i++) {
            for (int j = 0; j < planets[i].length; j++) {
                System.out.print("Enter planet[" + i + "][" + j + "]: ");
                planets[i][j] =  scan.nextLine();
            }
        }

        // [Section] Enhanced Nested For Loop / For Each Loop
        System.out.println("\nPrinting all the planets:");
        for (String[] rows : planets) {
            for (String column : rows) {
                System.out.println(column);
            }
            System.out.println();
        }
    }
}
