package com.joysistvi.stage1.day11;
import java.util.Scanner;

public class StringClass {

        public static void main(String[] args) {
            // toUpperCase()
            // toLowerCase()
            // charAt(index)
            // length()
            // equals()
            // equalsIgnoreCase()
            // concat()

            String word = "Java";

            //System.out.println(word.toUpperCase().charAt(0));

            System.out.println("Hello " + word);

            // method chaining
            // nextLine().charAt()

            // Exit Confirmation
            Scanner sc = new Scanner(System.in);
            System.out.println("Are you sure that you really want to exit");
            System.out.print("Enter Y to confirm: ");
            char gender = sc.nextLine().toUpperCase().trim().charAt(0);

            if (gender == 'Y') {
                System.out.println("Exiting....");
                System.exit(0); // Exit the whole application
            }


        }
    }

