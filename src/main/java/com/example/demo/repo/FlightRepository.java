package com.example.demo.repo;

import com.example.demo.model.Flight;
import com.example.demo.model.SearchCriteria;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightRepository {

    public List<Flight> getAllFlights(){
        List<Flight> flights = null;
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/flights.json"));
            // convert JSON file to map
            ArrayList<LinkedTreeMap> list = gson.fromJson(reader, ArrayList.class);
            flights = list.stream()
                    .map(s -> gson.fromJson(gson.toJson(s), Flight.class))
                    .collect(Collectors.toList());

            // print flight numbers
            flights.forEach(f->System.out.println(f.getFlightNumber()));

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flights;
    }

    public List<Flight> searchFlightsByCriteria(SearchCriteria s){
        List<Flight> flights = getAllFlights();
        List<Flight> retFlight;
        if(s.getFlightNum()!=null||!s.getFlightNum().isEmpty())
            retFlight=flights.stream()
                    .filter(f->f.getFlightNumber().equals(s.getFlightNum()))
                    .collect(Collectors.toList());
        else
            retFlight=flights.stream()
                    .filter(f->((f.getOrigin().equals(s.getOrigin()))&&(f.getDestination().equals(s.getDestination()))))
                    .collect(Collectors.toList());
        retFlight.stream().filter(f->f.getDeparture().equals(s.getDate())).collect(Collectors.toList());

        return retFlight;
    }
}
