package edu.sabanciuniv.questions;

public class Q4_ExceptionsGym {
    public static void main(String[] args) {
        System.out.print("a");
        try {
            System.out.print("b");
            throw new IllegalArgumentException();
        } catch (RuntimeException e) {
            System.out.print("c");
        } finally {
            System.out.print("d");
        }
        System.out.print("e");
    }
}

// abe
// abce
// abde
// abcde
// The code does not compile.
// An uncaught exception is thrown.