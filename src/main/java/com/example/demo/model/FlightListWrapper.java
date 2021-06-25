package com.example.demo.model;

public class FlightListWrapper {

    private Flight flight = new Flight();

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "FlightList [Flight=" + flight
                + "]";
    }
}
