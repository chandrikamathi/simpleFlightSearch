package com.united.flight.search.service;
import com.united.flight.search.model.Flight;
import com.united.flight.search.utilities.FlightJsonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FlightServiceImpl {

    @Autowired
    private FlightJsonFilter filter;

    public List<Flight> getFlightsBasedOnCriteria(String flightNum, String origin, String destination, String departure) {
        return filter.getFlightsBasedOnCriteria(flightNum, origin, destination, departure);
    }
}
