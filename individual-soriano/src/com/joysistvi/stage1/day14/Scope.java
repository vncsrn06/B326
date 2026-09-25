package com.joysistvi.stage1.day14;

public class Scope {

    public static void main(String[] args) {
        System.out.println(name);
        printName();

        Scope scope = new Scope();
        System.out.println(scope.age);
        scope.printAge();

        int x = 10; // local variable

        // loops, switch, trycatch
        if (true) {
            double balance = 100.0;  // block-scope variable
            System.out.println(balance);
            System.out.println(x);
        }

        //System.out.println(balance);
    }



    static String name = "Winter"; // static variable

    public static void printName() { // static method
        System.out.println(name);

    }

    int age = 30; // instance variable

    public void printAge() { // instance method
        System.out.println(age);
    }


}

/*    A         B        Result
    static to static     direct
    static to instance   direct
    instance to static   instantiate
    instance to instance direct
 */