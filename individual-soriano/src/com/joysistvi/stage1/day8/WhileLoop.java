package com.joysistvi.stage1.day8;

import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {

        //[Syntax]
        /*
        initialization
        while (condition) {
        statement / body of the loop
        inc / dec
        }

         */
        // print number 1 to 10



    /*    int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }
}

/*
While loop - Used when  the number of repetition is unknown in advance
 */


        Scanner scanner = new Scanner(System.in);

        boolean isRunning = false;

        while (!isRunning) {
            System.out.println("Type 'exit' to stop: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program Stopped");
                isRunning = true;
            }
        }
    }
}

// flag -> used to track / mark a variable  whether a specific condition or a event has occured