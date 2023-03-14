package edu.sabanciuniv.questions;

public class Q7_LogicalOperatorTest {
    public static void main(String[] args) {
        int x = 0;

        // && --> Conditional AND (circuit breaker)
        // & --> Boolean Logical AND (non-circuit breaker)
       //if (false & (1 == ++x)) {
       //    System.out.println("Inside in if...");
       //}

       System.out.println(x); // ???

        if ((x != 0) && (1 / x > 1)) {
            System.out.println("Inside of second if");
        }
    }
}
