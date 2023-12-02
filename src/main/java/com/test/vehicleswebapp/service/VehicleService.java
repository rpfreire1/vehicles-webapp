package com.test.vehicleswebapp.service;

import com.test.vehicleswebapp.model.Vehicle;

import java.util.List;
import javax.ejb.Local;
public interface VehicleService {
    public List<Vehicle> listVehicles();
    public void registerVehicle(Vehicle vehicle);
}
