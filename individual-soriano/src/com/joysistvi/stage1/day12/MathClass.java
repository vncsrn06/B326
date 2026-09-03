package com.joysistvi.stage1.day12;

public class MathClass {
    public static void main(String[] args) {
        int roll = (int) (Math.random() * 75) +1;

        String letter;

        if (roll <= 15 ) {
            letter = "B";
        } else if (roll <= 30 ) {
        letter = "I";
        } else if (roll <= 45 ) {
            letter = "N";
        } else if (roll <= 60 ) {
            letter = "G";
        } else {
            letter = "O";
        }
        System.out.println("Sa Letra ng " + letter + ": " + roll);
    }
}
