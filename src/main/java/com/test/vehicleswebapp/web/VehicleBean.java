package com.test.vehicleswebapp.web;


import com.test.vehicleswebapp.model.Model;
import com.test.vehicleswebapp.model.Vehicle;
import com.test.vehicleswebapp.service.VehicleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("vehicleBean")
@RequestScoped
public class VehicleBean {
    Logger log = LogManager.getRootLogger();
    List<Vehicle> vehicles;
    List<Model> models;
    @Inject
    private VehicleService vehicleService;
    private Vehicle vehicleSelected;

    public VehicleBean() {
        log.debug("Starting Bean Instantiate");
    }

    @PostConstruct
    public void instantiate() {
        this.vehicles = vehicleService.listVehicles();
        this.models=vehicleService.listAllVehiclesModels();
        log.debug("ManagedBean Objects retrieved" + this.vehicles);
        this.vehicleSelected = new Vehicle();
    }

    public Vehicle getVehicleSelected() {
        return vehicleSelected;
    }

    public void setVehicleSelected(Vehicle vehicleSelected) {
        this.vehicleSelected = vehicleSelected;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public List<Model> getModels(){return  models;}


    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void registerVehicle() {
        this.vehicleService.registerVehicle(vehicleSelected);
        this.vehicles.add(vehicleSelected);
        this.vehicleSelected = null;
    }

    public void resetVehicleSelected() {
        this.vehicleSelected = new Vehicle();
    }

}
