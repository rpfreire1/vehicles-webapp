package com.test.vehicleswebapp.dao.impl;

import com.test.vehicleswebapp.dao.VehicleDao;
import com.test.vehicleswebapp.model.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

public class
VehicleDaoImpl implements VehicleDao {
    @PersistenceContext(unitName = "VehiclePU")
    EntityManager em;

    @Override
    public List<Vehicle> findAllVehicles() {

        return em.createNamedQuery("Vehicle.findAll").getResultList();
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        em.persist(vehicle);
    }

    @Override
    public List<Vehicle> findVehiclesByPurchasedDateOrMaintenanceDate(LocalDate purchasedDate) {
        return em.createNamedQuery("Vehicle.findByPurchasedDateOrMaintenanceDate").getResultList();
    }

}
