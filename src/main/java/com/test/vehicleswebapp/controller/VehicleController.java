package com.test.vehicleswebapp.controller;

import com.test.vehicleswebapp.model.Vehicle;
import com.test.vehicleswebapp.service.VehicleService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.time.LocalDate;
import java.util.List;


@Path("/vehicles")
@Stateless
public class VehicleController {
    @Inject
    private VehicleService vehicleService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehicle> getAllVehicles() {
        return vehicleService.listVehicles();
    }

    @GET
    @Path("{dateToSearch}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehicle> getVehiclesMaintenancceDateSchedule(@PathParam("dateToSearch") String dateToSearch) {
        LocalDate dateSearch = LocalDate.parse(dateToSearch);
        System.out.println("entro");
        List<Vehicle> vehicles = vehicleService.findVehiclesMaintenanceDateSchedule(dateSearch);
        if (vehicles.isEmpty()) {
            return null;
        }
        return vehicles;

    }


    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response registerVehicle(Vehicle vehicle) {
        try {
            vehicleService.registerVehicle(vehicle);
            return Response.ok().entity(vehicle).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
