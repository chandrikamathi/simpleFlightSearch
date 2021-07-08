package com.example.demo.service;

import com.example.demo.model.Flight;
import com.example.demo.model.SearchCriteria;
import com.example.demo.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.getAllFlights();
    }

    public List<Flight> searchFlightsByCriteria(SearchCriteria s){
        return flightRepository.searchFlightsByCriteria(s);
    }

}
