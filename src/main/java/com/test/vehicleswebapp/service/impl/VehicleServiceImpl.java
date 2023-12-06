package com.test.vehicleswebapp.service.impl;

import com.test.vehicleswebapp.common.util.HolidayDaysUtil;
import com.test.vehicleswebapp.dao.ModelDao;
import com.test.vehicleswebapp.dao.VehicleDao;
import com.test.vehicleswebapp.model.Model;
import com.test.vehicleswebapp.model.Vehicle;
import com.test.vehicleswebapp.rest.dto.PriceResDto;
import com.test.vehicleswebapp.rest.service.PriceRestConsumeService;
import com.test.vehicleswebapp.service.VehicleService;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

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
    public List<Vehicle> findVehiclesMaintenanceDateSchedule(LocalDate filteredDate) {

        List<Vehicle> vehicleList = vehicleDao.findVehiclesByPurchasedDateOrMaintenanceDate(filteredDate);
        if (vehicleList.size() == 0 || vehicleList.isEmpty()) {
            return null;
        }
        return vehicleList;
    }

    @Override
    public List<Model> listAllVehiclesModels() {
        return modelDao.findAllModels();
    }

    @Override
    public void registerVehicle(Vehicle vehicle) {
        try {
            PriceResDto price = new PriceResDto();
            price = priceRestConsumeService.getPriceVehicle(vehicle.getVehiclePlates());
            vehicle.setVehiclePrice(price.getPrice());

            LocalDate dateTempMaintenance = vehicle.getVehiclePurchasedDate().plusDays(60);
            List<LocalDate> holidays = HolidayDaysUtil.getHolidays();
            while (holidays.contains(dateTempMaintenance)) {
                if (holidays.contains(dateTempMaintenance)) {
                    dateTempMaintenance = dateTempMaintenance.plusDays(1);
                }
            }
            DayOfWeek dayOfWeek = dateTempMaintenance.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY) {
                dateTempMaintenance = dateTempMaintenance.plusDays(2);
            } else if (dayOfWeek == DayOfWeek.SUNDAY) {
                dateTempMaintenance = dateTempMaintenance.plusDays(1);
            }
            vehicle.setVehicleLastMaintenance(dateTempMaintenance);

            vehicleDao.createVehicle(vehicle);

        } catch (Throwable t) {
            context.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }
}
