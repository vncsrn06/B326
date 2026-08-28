package com.joysistvi.stage1.day9;

public class NestedForLoop {
    public static void main(String[] args) {
        //           5 >= 1
        for( int i = 5; i >= 1 ; i-- ) {

            //          1 <= 5
            for( int j = 1; j <= i; j++ ) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
