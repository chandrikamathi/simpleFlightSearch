package com.example.demo.service;

import com.example.demo.model.Flight;
import com.example.demo.repo.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FlightServiceTdd {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;
    List<Flight> list = new ArrayList<Flight>();
    @BeforeEach
    public void setMockReturnFlights(){
        Flight f1 = new Flight();
        Flight f2 = new Flight();

        list.add(f1);
        list.add(f2);

    }

    @Test
    public void fetch_getAllFlights(){
        when(flightRepository.getAllFlights()).thenReturn(list);
        assertEquals(flightService.getAllFlights().size(), 2);

    }

    @Test
    public void fetch_getAllFlights_Null(){
        when(flightRepository.getAllFlights()).thenReturn(null);
        assertNull(flightService.getAllFlights());

    }

}
