package com.example.Backend2;


import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.*;


@RestController
public class VehicleController {
    
    @GetMapping("/vehicles")
    public ArrayList<Vehicle> getVehicles() throws IOException{
        JsonManager manager = new JsonManager();
        ArrayList<Vehicle> vehicles = manager.getVehicles();

        return vehicles;
    }

    @PostMapping("/vehicles")
    public ArrayList<Vehicle> createVehicle(@RequestBody Vehicle newVehicle) throws IOException {
        JsonManager manager = new JsonManager();
        ArrayList<Vehicle> vehicleList = manager.getVehicles();

        // sin datos de entrada, se genera un vehículo aleatorio
        // newVehicle.setLicensePlate("YYY-0000");
        // newVehicle.setMake("Toyota");
        // newVehicle.setModel("Yaris GR");
        // newVehicle.setType("Copue");
        // newVehicle.setYear(2021);
        // newVehicle.setAvailability(true);

        vehicleList.add(newVehicle);
        manager.saveVehicles(vehicleList);

        return vehicleList;
    }
}
