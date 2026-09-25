    package com.joysistvi.stage2.day17;

    // Employee

    import java.util.Scanner;

    // Access Modifier
    public class A {

        public String name;

        public void printName(){}

        private int age;

        private void printAge(){}

        protected String address;

        protected void printAddress(){}

        // default access modifier -> package private
        String color;

        void printColor(){}

        public static void main(String[] args) {
            A a = new A();


            System.out.println(a.age);
            a.printAge();

            a.printAddress();

            a.printColor();
        }
    }