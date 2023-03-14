package edu.sabanciuniv.questions;

public class Q5_ShorthandOperatorTest {
    public static void main(String[] args) {
        int x = 2;
        int y = x++; // Post-increment , x = x + 1
        int z = x--; // Post-decrement , x = x + 1

        System.out.print("   x:" + x); // 2
        System.out.print(" , y:" + y); // 2
        System.out.print(" , z:" + z); // 3
        System.out.print(" , x:" + x); // 2
    }
}

// x:2 , y:3 , z:1 , x:2
// x:2 , y:2 , z:3 , x:2
// x:2 , y:3 , z:2 , x:2
// x:2 , y:3 , z:1 , x:3
