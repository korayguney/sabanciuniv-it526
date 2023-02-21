package edu.sabanciuniv;

import jakarta.persistence.Entity;

@Entity
public class Motorcycle extends Vehicle {
    private double enginePower;

    public Motorcycle(String model, int year, String plate, double enginePower) {
        super(model, year, plate);
        this.enginePower = enginePower;
    }

    public Motorcycle(double enginePower) {
        this.enginePower = enginePower;
    }

    public Motorcycle(){}

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "enginePower=" + enginePower +
                "} " + super.toString();
    }
}
