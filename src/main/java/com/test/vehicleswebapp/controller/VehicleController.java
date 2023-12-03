package com.test.vehicleswebapp.controller;

import com.test.vehicleswebapp.model.Vehicle;
import com.test.vehicleswebapp.service.VehicleService;


import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;


@Path("/vehicles")
@Stateless
public class VehicleController {
    @Inject
    private VehicleService vehicleService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehicle> getAllVehicles(){
        return vehicleService.listVehicles();
    }
/*
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehicle> getVehiclesMaintenancceDateSchedule(Date dateToSearch){

    }

 */

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response registerVehicle(Vehicle vehicle){
        try {
            vehicleService.registerVehicle(vehicle);
            return Response.ok().entity(vehicle).build();
        }catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
