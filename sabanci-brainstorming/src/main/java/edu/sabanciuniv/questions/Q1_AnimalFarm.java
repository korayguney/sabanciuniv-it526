package edu.sabanciuniv.questions;

public class Q1_AnimalFarm {
    public static void main(String[] args) {
        final String pig = "lenght: 10";
        final String dog = "lenght: " + pig.length();
        System.out.println("Animals are equal: " + pig.equals(dog));
    }
}

//    Animals are equal: false
//    Animals are equal: true
//    false
//    an exception throwns
