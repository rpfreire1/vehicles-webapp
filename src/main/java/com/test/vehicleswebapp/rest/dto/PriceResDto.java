package com.test.vehicleswebapp.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PriceResDto {
    private String vehiclePlates;
    private Double price;

    public PriceResDto() {

    }

    public PriceResDto(String vehiclePlates, Double price) {
        this.vehiclePlates = vehiclePlates;
        this.price = price;
    }

    public String getVehiclePlates() {
        return vehiclePlates;
    }

    public void setVehiclePlates(String vehiclePlates) {
        this.vehiclePlates = vehiclePlates;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceResDto{" + "vehiclePlates='" + vehiclePlates + '\'' + ", price=" + price + '}';
    }

}
