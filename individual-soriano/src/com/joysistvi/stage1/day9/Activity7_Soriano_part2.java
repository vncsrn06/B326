package com.joysistvi.stage1.day9;

public class Activity7_Soriano_part2 {
    public static void main(String[] args) {

        for( int i = 1; i <= 10; i++) {
            System.out.println("Multiplication Table of " + i);

            for( int j = 1; j <= 10; j++ ) {

                int product = i * j;

                System.out.println(i + " x " + j + " = " + product);
            }
            System.out.println();
        }
    }
}
