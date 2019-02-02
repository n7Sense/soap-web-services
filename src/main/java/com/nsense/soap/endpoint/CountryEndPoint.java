package com.nsense.soap.endpoint;

import com.nsense.artifact.country.GetCountryRequest;
import com.nsense.artifact.country.GetCountryResponse;
import com.nsense.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndPoint {

    private CountryService countryService;

    @Autowired
    public CountryEndPoint(CountryService countryService) {
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = "http://artifact.nsense.com/country", localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryService.findCountry(request.getName()));
        return response;
    }
}