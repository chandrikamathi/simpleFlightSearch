package com.united.flight.search.controller;

import com.united.flight.search.model.Flight;
import com.united.flight.search.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightServiceImpl flightService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView helloWorld(){
        String message = "<h3>Search Flight Status </h3>";
        return new ModelAndView("index", "message", message);
    }

    @RequestMapping(value="/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView findFlight(@RequestParam String flightNum,
                                   @RequestParam String origin
            , @RequestParam String destination
            , @RequestParam(required = false) Date departure
            , @RequestParam(defaultValue = "false", required = false, value = "return") Boolean ret) {

        ModelAndView mav = new ModelAndView("flightStatus");
        List<Flight> fl = flightService.getFlightsBasedOnCriteria(flightNum, origin, destination, departure.toString());
        mav.addObject("flights", fl);
        return mav;

    }


}
