package com.joysistvi.stage2.day17;

import java.util.Scanner;

public class Activity12Soriano {

    // public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    //  System.out.println("Enter a number");
    // int number = scanner.nextInt();

    // if (number % 2 == 0) {
    //      System.out.println(number + " is even.");
    //  } else {
    //      System.out.println(number + " is odd.");

    //  for (int i = 1; i <= 50; i++) {
    //      System.out.println("Vince");

    //  static double squareRoot(double number) {
    //        return Math.sqrt(number);
//      }

    // public static void main(String[] args) {

    //     Scanner scanner = new Scanner(System.in);

    //      System.out.println("Enter a number:");
    //     double number = scanner.nextDouble();

    //    double answer = squareRoot(number);

    //   System.out.println("Square root: " + answer);

    //  static double power(double base, double exponent) {
    //      return Math.pow(base, exponent);
    //  }

    //  public static void main(String[] args) {

    //     Scanner scanner = new Scanner(System.in);

    //     System.out.println("Enter the base:");
    //    double base = scanner.nextDouble();

    //   System.out.println("Enter the exponent:");
    //     double exponent = scanner.nextDouble();

    //   double answer = power(base, exponent);

    //   System.out.println("Power: " + answer);

    //    scanner.close();

   /* public static void main(String[] args) {
        randomNumber();

    }

    static void randomNumber() {
        int number = (int) (Math.random() * 100) + 1;
        System.out.println("Random number: " + number);
    }

} */

  /*  static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the radius:");
        double radius = scanner.nextDouble();

        double area = circleArea(radius);

        System.out.println("Circle area: " + area);

        scanner.close();
    }
}
*/

 /*   static void voter(int age) {
        if (age >= 18) {
            System.out.println("The person is a voter.");
        } else {
            System.out.println("The person is not a voter.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age:");
        int age = scanner.nextInt();

        voter(age);

        scanner.close();
    }
}
  */

    /*    static int wordLength(String word) {
            return word.length();
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a word:");
            String word = scanner.next();

            int length = wordLength(word);

            System.out.println("Length of the word: " + length);

            scanner.close();
        }
    }
    */
/*
    static void reverseWord(String word) {
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        System.out.println("Reverse Word: " + reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word:");
        String word = scanner.next();

        reverseWord(word);

        scanner.close();
    }
}
*/

    static void nameAndAge(String name, int age) {
        System.out.println("Full Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your full name:");
        String name = scanner.nextLine();

        System.out.println("Enter your age:");
        int age = scanner.nextInt();

        nameAndAge(name, age);

        scanner.close();
    }
}



