package com.joysistvi.stage1.day11;

public class Activity9_Soriano_2 {
    public static void main(String[] args) {

        String country = "Philippines";
        char firstCharacter = country.charAt(0);
        char lastCharacter = country.charAt(10);

        System.out.println("Country: " + country);

        System.out.println("First character: " + firstCharacter);

        System.out.println("Last character: " + lastCharacter);

        int PsCount = 0;
        int vowelCount = 0;

        for (char character : country.toCharArray()) {

            if (character == 'P' || character == 'p') {
                PsCount++;
            }
            if (character == 'a' || character == 'e' ||
                    character == 'i' || character == 'o' ||
                    character == 'u') {
                vowelCount++;
            }
        }
            System.out.println("Number of P/p: " + PsCount);
            System.out.println("Number of vowels: " + vowelCount);
        }

    }

