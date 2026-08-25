package com.joysistvi.stage1.day6;

public class SwitchStatement {
    public static void main(String[] args) {
        String months = "";

        switch (months) {
            case "January":
            case "February":
            case "March":
                System.out.println("First Quarter of the year.");
                break;
            case "April":
            case "May":
            case "June":
                System.out.println("Second Quarter of the year.");
                break;
            case "July":
            case "August":
            case "September":
                System.out.println("Third Quarter of the year.");
                break;
            case "October":
            case "November":
            case "December":
                System.out.println("Fourth Quarter of the year.");
                break;
                default:
                    System.out.println("Invalid Input! Please enter a valid Months.");
        }

        // Switch Expression Arrow Syntax (MODERN)
    }
    /*
    Pwede: String, Byte, Short, Int, Enum
    Bawal: Float, Long, Double, Boolean
     */
}
