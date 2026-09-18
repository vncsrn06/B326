package com.joysistvi.stage2.day26;
import java.util.Scanner;
// Exception
public class ExceptionsHandling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

            // Array example
            int[] numbers = {1, 2, 3, 4, 5};

            System.out.println("\n[ArrayIndexOutOfBoundsException]");
            try {
                System.out.println(numbers[6]);
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }

            System.out.println("Ang pogi ko");


            // StringIndexOutOfBoundsException
            System.out.println("\n[StringIndexOutOfBoundsException]");
            try {
                System.out.print("Enter a word: ");
                String word = sc.nextLine();

                System.out.print("Enter an index: ");
                int index = sc.nextInt();
                sc.nextLine();

                System.out.println("Character: " + word.charAt(index));

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("ERROR The index is outside the word.");
            }


            // NullPointerException
            System.out.println("\n[NullPointerException]");
            try {
                String name = null;

                System.out.println("Name length: " + name.length());

            } catch (NullPointerException e) {
                System.out.println("ERROR The value is null.");
            }


            // NumberFormatException
            System.out.println("\n[NumberFormatException]");
            try {
                System.out.print("Enter a number: ");
                String number = sc.nextLine();

                int value = Integer.parseInt(number);

                System.out.println("Your number is: " + value);

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter a valid number.");
            }


            // ArithmeticException
            System.out.println("\n[ArithmeticException]");
            try {
                System.out.print("Enter the first number: ");
                int num1 = sc.nextInt();

                System.out.print("Enter the second number: ");
                int num2 = sc.nextInt();

                System.out.println("Result: " + (num1 / num2));

            } catch (ArithmeticException e) {
                System.out.println("You cannot divide by zero.");
            }
            sc.close();
        }
    }




