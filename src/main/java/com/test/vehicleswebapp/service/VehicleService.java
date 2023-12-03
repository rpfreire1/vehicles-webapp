package com.test.vehicleswebapp.service;

import com.test.vehicleswebapp.model.Model;
import com.test.vehicleswebapp.model.Vehicle;

import java.time.LocalDate;
import java.util.List;


public interface VehicleService {
    List<Vehicle> listVehicles();

    List<Vehicle> findVehiclesMaintenanceDateSchedule(LocalDate filteredDate);

    List<Model> listAllVehiclesModels();

    void registerVehicle(Vehicle vehicle);
}
