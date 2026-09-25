package com.joysistvi.stage1.day12;

import java.util.Random;

public class MathClass {

    public static void main(String[] args) {

        int roll = (int) (Math.random() * 75) +1;

        String letter;

        System.out.println("Bingo Simulator\n");
        if (roll <= 15) { // 1 - 15
            letter = "B";
        } else if (roll <= 30) { // 16 - 30
            letter = "I";
        } else if (roll <= 45) { // 31 - 45
            letter = "N";
        } else if (roll <= 60) { // 46 - 60
            letter = "G";
        } else {
            letter = "O"; // 60 - 75
        }

        System.out.println("Sa letra ng " + letter + " : " + roll);




        // BINGO
        /*
            B: 1-15
            I: 16-30
            N: 31-45
            G: 46-60
            O: 61-75
         */



    }
}

    /* Random Class
        Random random = new Random();
            System.out.println(random.nextInt(58) + 1);
     */


// Bingo Simulator
// 1 - 58
// 0.0 - 1.0

// Parsing -> converting a String to primitive datatype or vice versa
// Casting -> Number Class ex: double -> int

// Casting (Upcasting and Downcasting)

// Downcasting
//    double decNum = 58.59;
//
//    int num = (int) decNum;
//        System.out.println(num);
//
//    // Upcasting
//    byte x = 10;
//
//    float y = x;
//        System.out.println(y);

// byte short int long float double