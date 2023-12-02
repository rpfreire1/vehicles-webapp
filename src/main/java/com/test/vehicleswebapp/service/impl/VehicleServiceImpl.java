package com.test.vehicleswebapp.service.impl;

import com.test.vehicleswebapp.dao.ModelDao;
import com.test.vehicleswebapp.dao.VehicleDao;
import com.test.vehicleswebapp.model.Model;
import com.test.vehicleswebapp.model.Vehicle;
import com.test.vehicleswebapp.rest.dto.PriceResDto;
import com.test.vehicleswebapp.rest.service.PriceRestConsumeService;
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
    @Inject
    private ModelDao modelDao;
    @Inject
    private PriceRestConsumeService priceRestConsumeService;

    @Resource
    private SessionContext context;

    @Override
    public List<Vehicle> listVehicles() {
        return vehicleDao.findAllVehicles();
    }

    @Override
    public List<Model> listAllVehiclesModels() {
        return modelDao.findAllModels();
    }

    @Override
    public void registerVehicle(Vehicle vehicle) {
        try {
            PriceResDto price=new PriceResDto();
            price=priceRestConsumeService.getPriceVehicle(vehicle.getVehiclePlates());
            vehicle.setVehiclePrice(price.getPrice());
            vehicleDao.createVehicle(vehicle);
        } catch (Throwable t) {
            context.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }
}
