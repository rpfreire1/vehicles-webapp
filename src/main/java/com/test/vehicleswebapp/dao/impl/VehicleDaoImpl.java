package com.test.vehicleswebapp.dao.impl;
import com.test.vehicleswebapp.dao.VehicleDao;
import com.test.vehicleswebapp.model.Vehicle;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
public class VehicleDaoImpl implements VehicleDao {
    @PersistenceContext(unitName="VehiclePU")
    EntityManager em;
    @Override
    public List<Vehicle> findAllVehicles() {
        return em.createNamedQuery("Vehicle.findAll").getResultList();
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        em.persist(vehicle);
    }
}