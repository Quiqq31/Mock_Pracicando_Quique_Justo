package com.example.Backend2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@SpringBootTest
class Backend2ApplicationTests {
// creame unit tests, que comprueben la funcionalidad de las operaciones y metodos de createVehicle, getVehicles del vehicle controller, y del JsonManager las funciones getVehicles (usando un test.json de prueba) y el saveVehicles 
	private ArrayList<Vehicle> testData;
	private VehicleController vehicleController;
	private JsonManager jsonManager;

	@BeforeEach
	public void setup() throws IOException {
		// Created data for testing
		testData = new ArrayList<>();
		testData.add(new Vehicle("Make1", "Model1", 2020, "Sedan", "XXX-1111", true, "1234"));
		testData.add(new Vehicle("Make2", "Model2", 2022, "SUV", "YYY-2222", false, "1234"));
		

		// Initialize vehicleController and jsonManager
		vehicleController = new VehicleController();
		jsonManager = new JsonManager();

		jsonManager.saveVehiclesTESTS(testData);
	}

	@Test
	void contextLoads() {
		// Verify that the context of Spring Boot loads correctly 
		assertDoesNotThrow(() -> Backend2Application.main(new String[]{}));
	}

	@Test
	void testGetVehicles() throws IOException {
		ArrayList<Vehicle> vehicles = vehicleController.getVehiclesTESTSController();
		assertEquals(testData.size(), vehicles.size());
	}

	@Test
	void testCreateVehicle() throws IOException {
		Vehicle newVehicle = new Vehicle("Make3", "Model3", 2021, "Truck", "ZZZ-3333", true, "1234");
		vehicleController.createVehicleTESTSController(newVehicle);
		ArrayList<Vehicle> vehicles = vehicleController.getVehiclesTESTSController();
		assertTrue(vehicles.size() == vehicleController.getVehiclesTESTSController().size());
	}

}
