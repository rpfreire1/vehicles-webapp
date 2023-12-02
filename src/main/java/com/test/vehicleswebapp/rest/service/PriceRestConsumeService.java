package com.test.vehicleswebapp.rest.service;

import com.test.vehicleswebapp.rest.dto.PriceResDto;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

public class PriceRestConsumeService {
    private static final String URL_BASE="https://auto.jedai.workers.dev?placa=";
    private static Client client;
    private static WebTarget webTarget;

    private static Invocation.Builder invocationBuilder;

    private static Response response;

    private static PriceResDto priceResDto;
    public PriceResDto getPriceVehicle(String vehiclePlates){
        PriceResDto price=new PriceResDto();
        client = ClientBuilder.newClient();
        webTarget = client.target(URL_BASE).path(vehiclePlates);
        price = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(PriceResDto.class);

        return price;
    }
}
