package com.test.vehicleswebapp.web;

import com.test.vehicleswebapp.model.Vehicle;
import com.test.vehicleswebapp.service.VehicleService;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/vehicles")
public class VehicleServlet extends HttpServlet{
    @Inject
    VehicleService vehicleService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Vehicle> vehicles = vehicleService.listVehicles();
        System.out.println("vehicles:" + vehicles);
        request.setAttribute("vehicles", vehicles);
        request.getRequestDispatcher("/vehiclesList.jsp").forward(request, response);
    }
}
