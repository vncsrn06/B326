package com.joysistvi.stage1.day14;

public class Main {

    public static void main(String[] args) {
        // static
        System.out.println(Scope.name);
        Scope.printName();

        Scope scope = new Scope();
        System.out.println(scope.age);

        scope.printAge();

    }
}