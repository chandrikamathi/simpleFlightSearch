package com.example.demo.controller;

import com.example.demo.model.Flight;
import com.example.demo.model.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping(value="/flights", method= RequestMethod.GET)
    public ResponseEntity<List<Flight>> getAllFlights()
    {
        return new ResponseEntity<List<Flight>>(flightService.getAllFlights(), HttpStatus.OK);


    }

    @RequestMapping(value="/search", method= RequestMethod.POST,headers = "Accept=*/*",produces = "application/json", consumes="application/json")
    public ResponseEntity<List<Flight>> searchFlights(@RequestBody SearchCriteria criteria)
    {
        return new ResponseEntity<List<Flight>>(flightService.searchFlightsByCriteria(criteria), HttpStatus.OK);


    }

}
