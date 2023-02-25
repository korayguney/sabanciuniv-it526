package edu.sabanciuniv.sabanci04.model;

public class Student {
    private String name;
    private int age;
    private char gender;
    private int schoolNumber;

    public Student(String name, int age, char gender, int schoolNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.schoolNumber = schoolNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }
}
