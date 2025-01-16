package com.example.Backend2;


import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.*;


@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    
    @GetMapping("/vehicles")
    public ArrayList<Vehicle> getVehicles() throws IOException{
        JsonManager manager = new JsonManager();
        ArrayList<Vehicle> vehicles = manager.getVehicles();

        return vehicles;
    }

    @PostMapping("/vehicles")
    public void createVehicle(@RequestBody Vehicle newVehicle) throws IOException {
        JsonManager manager = new JsonManager();
        ArrayList<Vehicle> vehicleList = manager.getVehicles();

        vehicleList.add(newVehicle);
        manager.saveVehicles(vehicleList);

    }
}
