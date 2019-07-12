package com.united.flight.search.utilities;

import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.united.flight.search.model.Flight;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

@Repository
public class FlightJsonFilter {

    public List<Flight> getFlightsBasedOnCriteria(final String fNum, final String origin, final String destination, final String departure ){

        ObjectMapper mapper = new ObjectMapper();
        List<Flight> flightList = new ArrayList<>();
        try {
            File file = new File(this.getClass().getClassLoader().getResource("flight-sample.json").getFile());
            flightList = mapper.readValue(file, TypeFactory.defaultInstance().constructCollectionType(List.class, Flight.class));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        List<Flight> outputFlightList = new ArrayList<>();
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

    private boolean filterFlights(Flight flight, final String fNum, final String origin, final String destination, final String departure ){
        //(Flight Number || (Origin && Destination)) && Date
        return (flight.getFlightNumber().equals(fNum)
                    ||(flight.getOrigin().equals(origin)&&flight.getDestination().equals(destination)))
                    &&compareDates(flight.getDeparture(), departure);
    }

    private boolean compareDates(String flightDate, String selectedDate){
        Date date1 = null;
        Date date2 = null;
        try {
            date1=new SimpleDateFormat("dd/MM/yyyy").parse(selectedDate);
            date2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(flightDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        boolean equalDates = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);

        return equalDates;
    }
}
