import React, { useState, useEffect } from 'react';
import axios from 'axios';


export function Flight(){

    const [flights, setFlights] = useState([]);

    const fetchFlights = () => {
        axios.get("http://localhost:8080/flights").then(res => {
            console.log(res);
            setFlights(res.data);
        })
    }
/*
    const fetchFlightsBySearch = (props) => {
        axios.get("http://localhost:8080/search", search).then(res => {
            console.log(res);
            setFlights(res.data);

    }

   useEffect(() => {
    fetchFlightsBySearch();
    }, []);*/


    useEffect(() => {
    //setFlights(props.flightData);
    fetchFlights();
    }, []);



    return flights.map((flight, index) => {
        return (
            <div key={index}>
                <h2>{ flight.flightNumber}</h2>
                <p>{flight.carrier}</p>
                <p>{flight.origin}</p>
                <p>{flight.departure}</p>
                <p>{flight.destination}</p>
                <p>{flight.arrival}</p>
            </div>
        );
    });

}