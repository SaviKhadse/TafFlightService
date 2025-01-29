package com.tekarch.flight.TafFlightService.Service;

import com.tekarch.flight.TafFlightService.Model.Flight;
import com.tekarch.flight.TafFlightService.Service.Interface.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
//    private final String datastoreBaseUrl = "http://localhost:8081"; // Adjust based on taf-datastore-service URL


//    private final String datastoreBaseUrl = "http://18.188.81.176:8081"; // Adjust based on taf-datastore-service URL

    @Autowired
    private RestTemplate restTemplate;

    @Value("${flights.ms.url}")
    String flightsurl;

    @Override
    public List<Flight> getAllFlights() {
        return Arrays.asList(restTemplate.getForObject(flightsurl , Flight[].class));
    }

    @Override
    public Flight getFlightById(Long flightId) {
        return restTemplate.getForObject(flightsurl +"/" + flightId, Flight.class);
    }

    @Override
    public Flight addFlight(Flight flight) {
        return restTemplate.postForObject(flightsurl , flight, Flight.class);
    }

    @Override
    public Flight updateFlight(Long flightId, Flight flight) {
        restTemplate.put(flightsurl  + flightId, flight);
        return flight;
    }

    @Override
    public void deleteFlight(Long flightId) {
        restTemplate.delete(flig