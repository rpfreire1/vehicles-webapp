package com.test.vehicleswebapp.service;

import com.test.vehicleswebapp.model.Model;
import com.test.vehicleswebapp.model.Vehicle;

import java.time.LocalDate;

import java.util.List;


public interface VehicleService {
    public List<Vehicle> listVehicles();
    public List<Vehicle> findVehiclesMaintenanceDateSchedule(LocalDate filteredDate);
    public List<Model> listAllVehiclesModels();
    public void registerVehicle(Vehicle vehicle);
}
