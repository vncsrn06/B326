package com.joysistvi.stage1.day13;

public class Main {
    // Create an object -> Instantiation
    // ClassName Object
    public static void main(String[] args) {

        Laptop laptop = new Laptop();

        laptop.brand = "Mac";
        laptop.color = "Black";
        laptop.ramInGb = 12;
        laptop.weightInKg = 1.2;
        laptop.cpu = "M4";

        laptop.watchTutorial();
        laptop.playGames();

        Laptop laptop2 = new Laptop();
        laptop2.brand = "Msi";
        laptop2.color = "White";
        laptop2.ramInGb = 18;
        laptop2.weightInKg = 1.5;
        laptop2.cpu = "Ryzen";

        Laptop laptop3 = new Laptop();
        laptop3.brand = "Lenovo";
        laptop3.color = "Blue";
        laptop3.ramInGb = 24;
        laptop3.weightInKg = 1.9;
        laptop3.cpu = "I9";

    }
}
