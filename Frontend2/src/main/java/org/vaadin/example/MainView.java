package org.vaadin.example;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.combobox.ComboBox;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service) throws IOException, InterruptedException, URISyntaxException {

        // Set grid columns and populate with data

        Grid<Vehicle> grid = new Grid<>(Vehicle.class, false);
        grid.addColumn(Vehicle::getLicensePlate).setHeader("License Plate");
        grid.addColumn(Vehicle::getMake).setHeader("Make");
        grid.addColumn(Vehicle::getModel).setHeader("Model");
        grid.addColumn(Vehicle::getYear).setHeader("Year");
        grid.addColumn(Vehicle::getType).setHeader("Type");
        grid.addColumn(Vehicle::getUuid).setHeader("UUID");
        grid.addColumn(Vehicle::getAvailability).setHeader("Availability");

        ArrayList<Vehicle> vehicle = DataService.getVehicles();
        grid.setItems(vehicle);

        // Filter for Available and Not Available Vehicles

        ComboBox<String> availabilityFilter = new ComboBox<>("Availability");
        availabilityFilter.setItems("All", "Available", "Not Available");
        availabilityFilter.setValue("All");

        availabilityFilter.addValueChangeListener(event -> {
            String filterValue = event.getValue();
            if ("Available".equals(filterValue)) {
                grid.setItems(vehicle.stream().filter(Vehicle::getAvailability).collect(Collectors.toList()));
            } else if ("Not Available".equals(filterValue)) {
                grid.setItems(vehicle.stream().filter(v -> !v.getAvailability()).collect(Collectors.toList()));
            } else {
                grid.setItems(vehicle);
            }
        });

        // Add Vehicle trhough forms
        TextField licensePlateField = new TextField("License Plate");
        TextField makeField = new TextField("Make");
        TextField modelField = new TextField("Model");
        TextField yearField = new TextField("Year");
        ComboBox<String> typeField = new ComboBox<>("Type");
        typeField.setItems("SUV", "Truk","Sedan", "Coupe");
        ComboBox<Boolean> availabilityField = new ComboBox<>("Availability");
        availabilityField.setItems(true, false);

        Button addButton = new Button("Add Vehicle");
        addButton.addClickListener(e -> {
            String licensePlate = licensePlateField.getValue();
            String make = makeField.getValue();
            String model = modelField.getValue();
            int year = Integer.parseInt(yearField.getValue()); // XXXX
            String type = typeField.getValue();
            boolean availability = availabilityField.getValue(); // true or false

            Vehicle newVehicle = new Vehicle(make, model, year, type, licensePlate, availability);

            // Check if all fields are filled out, if not show an error message
            if (licensePlate.isEmpty() || make.isEmpty() || model.isEmpty() || yearField.isEmpty() || type == null || availabilityField.isEmpty()) {
                // Show an error message or notification
                Notification.show("All fields must be filled out.", 3000, Notification.Position.MIDDLE);
                return;
            }

            try {
                DataService.createVehicle(newVehicle);
                vehicle.add(newVehicle);
                grid.setItems(vehicle);
                Notification.show("Vehicle Created Succesfully", 3000, Notification.Position.MIDDLE);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        HorizontalLayout formLayout = new HorizontalLayout();
        
        formLayout.add(licensePlateField, makeField, modelField, yearField, typeField, availabilityField, addButton);
        add(formLayout);
        add(availabilityFilter);
        add(grid);

    }
}
