package com.united.flight.search.utilities;

import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.united.flight.search.model.Flight;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

@Repository
public class FlightJsonFilter {

    public List<Flight> getFlightsBasedOnCriteria(final String fNum, final String origin, final String destination, final String departure ){

        ObjectMapper mapper = new ObjectMapper();
        List<Flight> flightList = new ArrayList<Flight>();
        try {
            flightList = mapper.readValue(new File("../../flight-docs/flight-sample.json"), TypeFactory.defaultInstance().constructCollectionType(List.class, Flight.class));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        List<Flight> outputFlightList = new ArrayList<Flight>();
        if(flightList.size()>0) {
            flightList.forEach(flight -> {
                        if (filterFlights(flight, fNum, origin, destination, departure)) {
                            outputFlightList.add(flight);
                        }

                    }
            );
        }
        return flightList;
    }

    public boolean filterFlights(Flight flight, final String fNum, final String origin, final String destination, final String departure ){
        //(Flight Number || (Origin && Destination)) && Date
        return (flight.getFlightNumber().equals(fNum)
                    ||(flight.getOrigin().equals(origin)&&flight.getDestination().equals(destination)))
                    &&flight.getDeparture().equals(departure);
    }
}
