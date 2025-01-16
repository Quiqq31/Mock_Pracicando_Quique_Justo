package com.example.Backend2;

import java.util.UUID;

public class Vehicle {
    private String make;
    private String model;
    private int year;
    private String type;
    private String licensePlate;
    private String uuid;
    private boolean availability;

    public Vehicle(String make, String model, int year, String type, String licensePlate, boolean availability) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.licensePlate = licensePlate;
        this.uuid = UUID.randomUUID().toString();
        this.availability = availability;
    }

    // Constructor for the tests, because the UUID is not generated in the tests
    public Vehicle(String make, String model, int year, String type, String licensePlate, boolean availability, String id_general) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.licensePlate = licensePlate;
        this.uuid = id_general;
        this.availability = availability;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getUuid() {
        return uuid;
    }

    // No setter for UUID as it should be auto-generated

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
