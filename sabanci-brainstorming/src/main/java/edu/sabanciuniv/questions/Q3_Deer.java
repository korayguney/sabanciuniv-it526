package edu.sabanciuniv.questions;

class Deer {
    public Deer() {
        System.out.print("Deer");
    }

    public Deer(int age) {
        System.out.print("DeerAge");
    }

    private boolean hasHorns() {
        return false;
    }

    public static void main(String[] args) {
        Deer deer = new Reindeer(5);
        System.out.println("," + deer.hasHorns());
    }
}

class Reindeer extends Deer {
    public Reindeer(int age) {
        super();
        System.out.print("Reindeer");
    }

    public boolean hasHorns() {
        return true;
    }
}

//  DeerReindeer,false
//  DeerReindeer,true
//  ReindeerDeer,false
//  ReindeerDeer,true
//  DeerAgeReindeer,false
//  DeerAgeReindeer,true
//  The code will not compile because of line 7.
//  The code will not compile because of line 12.