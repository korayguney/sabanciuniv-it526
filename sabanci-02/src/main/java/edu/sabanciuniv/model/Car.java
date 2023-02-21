package edu.sabanciuniv.model;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {
    private String color;

    public Car(String model, int year, String plate, String color) {
        super(model, year, plate);
        this.color = color;
    }

    public Car(String color) {
        this.color = color;
    }

    public Car(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                "} " + super.toString();
    }
}
