package com.example.Backend2;

import java.util.UUID;

public class Vehicle {
    private String make;
    private String model;
    private int year;
    private String type;
    private String licensePlate;
    private String uuid;

    public Vehicle(String make, String model, int year, String type, String licensePlate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.licensePlate = licensePlate;
        this.uuid = UUID.randomUUID().toString();
    }

    // Getters and Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfManufacture() {
        return year;
    }

    public void setYearOfManufacture(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicensePlateNumber() {
        return licensePlate;
    }

    public void setLicensePlateNumber(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getUuid() {
        return uuid;
    }

    // No setter for UUID as it should be auto-generated
}
