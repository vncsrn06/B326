package com.joysistvi.stage2.day19;

public class Student {
    // private data members / private fields
    private int id;
    private String name;
    private int age;
    private String course;
    private String section;
    private String address;
    // getter method // accessor method

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getCourse(){
        return course;
    }
    public String getAddress() {
        return address;
    }
    public String getSection() {
        return section;
    }

    // setter method // mutator method
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public void setAddress(String address) {
        if (address != null && address.trim().length() >= 5) {
            this.address = address;
        } else {
            this.address = "Unknown";
        }
    }
}

