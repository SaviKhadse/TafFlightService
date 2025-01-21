package com.tekarch.flight.TafFlightService.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Flight {
    private Long id;

    @NotEmpty(message = "Flight number cannot be empty")
    private String flightNumber;

    @NotEmpty(message = "Departure location cannot be empty")
    private String departure;

    @NotEmpty(message = "Arrival location cannot be empty")
    private String arrival;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    private Integer availableSeats;

}