package com.test.vehicleswebapp.dao;

import com.test.vehicleswebapp.model.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface VehicleDao {
    List<Vehicle> findAllVehicles();

    void createVehicle(Vehicle vehicle);

    List<Vehicle> findVehiclesByPurchasedDateOrMaintenanceDate(LocalDate purchasedDate);
}
