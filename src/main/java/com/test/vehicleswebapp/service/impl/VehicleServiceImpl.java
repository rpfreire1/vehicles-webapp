package com.test.vehicleswebapp.service.impl;

import com.test.vehicleswebapp.dao.VehicleDao;
import com.test.vehicleswebapp.model.Vehicle;
import com.test.vehicleswebapp.service.VehicleService;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
@Stateless
public class VehicleServiceImpl implements VehicleService {
    @Inject
    private VehicleDao vehicleDao;

    @Resource
    private SessionContext context;

    @Override
    public List<Vehicle> listVehicles() {
        return vehicleDao.findAllVehicles();
    }

    @Override
    public void registerVehicle(Vehicle vehicle) {
        try {
            vehicleDao.createVehicle(vehicle);
        } catch (Throwable t) {
            context.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }
}
