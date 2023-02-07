package edu.sabanciuniv.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Accident {
    private LocalDate accidentDate;

    private List<Vehicle> vehicleList = new ArrayList<>();

    public Accident(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }

    public Accident(){}

    public LocalDate getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public String toString() {
        return "Accident{" +
                "accidentDate=" + accidentDate +
                '}';
    }
}
