package com.joysistvi.stage1.day11;

import java.util.Scanner;

public class Methods_Avaj {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // char variable = scanner.nextLine().charAt(index);
        System.out.println("Enter your name:");
        char name = scan.next().charAt(1);
        System.out.println("Letter:" + name);
        // check the string if it contains a specific sequence of characters. It returns on true or false
        String message = "Vince T. Soriano";
        String word = "TESTING";
        String wala = "a";
        String space = "                                   AAAAAAA                      ";
        String coffee ="I like Cappuccino";
        String newCoffee = coffee.replace("Cappuccino", "Java Chip");

        // Contains () = string.contains("sequence");
        System.out.println(message.contains("J"));
        // endsWith () = string.endsWith("Suffix")
        System.out.println(message.endsWith("Java"));
        // startsWith() = "Prefix";
        System.out.println(message.startsWith("Java"));
        // indexOf() = "Value";
        System.out.println(word.indexOf("s"));
        //string.isEmpty();
        System.out.println(wala.isEmpty());
        //string.trim();
        System.out.println(space.trim());
        //string.replace("OldValue", "NewValue")
        System.out.println(newCoffee);

        // string.toCharArray ();
        char[] letters = message.toCharArray();

        for (char letter : letters) {
            System.out.println(letter);



        }

        // String.valueOf(value);
        double price = 17.50;
        String priceText = String.valueOf(price);
        System.out.println(priceText);
    }


}

