package com.test.vehicleswebapp.dao;

import com.test.vehicleswebapp.model.Vehicle;

import java.util.List;

public interface VehicleDao {
    public List<Vehicle> findAllVehicles();
    public void createVehicle(Vehicle vehicle);
}