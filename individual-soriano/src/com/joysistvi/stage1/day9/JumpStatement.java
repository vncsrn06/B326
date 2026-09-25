package com.joysistvi.stage1.day9;

public class JumpStatement {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++)
        {

            for (int j = 1; j <= 10; j++) {
                if (j == 5) {
                    continue;

                }

                System.out.println(i + " " + j);

            }
            System.out.println();
        }
    }
}
