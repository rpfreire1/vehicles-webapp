package com.test.vehicleswebapp.rest.service;

import com.test.vehicleswebapp.rest.dto.PriceResDto;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PriceRestConsumeService {
    private static final String URL_BASE = "https://auto.jedai.workers.dev?placa=";
    private static Client client;
    private static WebTarget webTarget;

    private static Invocation.Builder invocationBuilder;

    private static Response response;

    private static PriceResDto priceResDto;

    public PriceResDto getPriceVehicle(String vehiclePlates) {
        PriceResDto price = new PriceResDto();
        client = ClientBuilder.newClient();
        webTarget = client.target(URL_BASE).path(vehiclePlates);
        price = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(PriceResDto.class);

        return price;
    }
}
