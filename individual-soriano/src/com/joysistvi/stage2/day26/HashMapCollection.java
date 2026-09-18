package com.joysistvi.stage2.day26;

import java.util.HashMap;
import java.util.Map;

public class HashMapCollection {

    public static void main(String[] args) {
        Map<String, String> students = new HashMap<>();
        students.put("name", "Dawson Yuno");
        students.put("ageInMonths", "18");
        students.put("address", "Orriental Mindoro");
        students.put("IsActive", "True");

        System.out.println(students);
    }

}
