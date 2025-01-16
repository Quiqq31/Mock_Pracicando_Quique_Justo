package com.example.Backend2;


import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.*;


@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private final String filePath = "src/main/resources/vehicles.json";
    

    @GetMapping
    public ArrayList<Vehicle> getVehicles() {


        return vehicles;
    }

    @PostMapping
    public void addVehicle(@RequestBody Vehicle vehicle) {
        
        
    }
}
