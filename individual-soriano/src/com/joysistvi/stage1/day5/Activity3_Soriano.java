package com.joysistvi.stage1.day5;

import java.util.Scanner;
public class Activity3_Soriano {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // Event Entry //

        System.out.println("--- Task 2: Event Entry Check ---");
        System.out.print("Enter your Age: ");
        int age=sc.nextInt();

        System.out.print("Do you have Valid ID? (yes/no): ");
        String id=sc.next();
        boolean hasValidID=id.equals("yes");

        boolean allowedtoEnter = age >= 18 && hasValidID;

        System.out.println("Allowed to enter the Event: " + (allowedtoEnter ? "Yes" : "No"));

        // Class Check //

        System.out.println("--- Task 3: Class Status Check ---");
        System.out.print("Is today a weekend? (yes/no): ");
        String weekend=sc.next();

        System.out.print("Is today a holiday? (yes/no): ");
        String holiday=sc.next();

        boolean isWeekend=weekend.equals("yes");
        boolean isHoliday=holiday.equals("yes");
        boolean isWeekendAndHoliday=isWeekend || isHoliday;

        System.out.println("Are there no classes today? " + (isWeekendAndHoliday ? "Yes" : "No"));

        // Student Grade //

        System.out.println("--- Task 4: Pass or Fail Check ---");
        System.out.print("Enter your score? ");
        int score=sc.nextInt();

        String result = score >= 75 ?"Passed" : "Failed";
        System.out.println("Result: " + result);

        // Larger Number Check //

        System.out.println("--- Task 5: Larger Number Check ---");
        System.out.print("Number 1: ");
        int num=sc.nextInt();

        System.out.print("Number 2: ");
        int num2=sc.nextInt();

        int larger = num > num2 ? num : num2;

        System.out.println("The larger number is " + larger);
    }
}
