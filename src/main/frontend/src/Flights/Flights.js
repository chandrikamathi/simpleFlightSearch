import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import React, {useState, useEffect, Component} from 'react';



const Flights = () => {

    const [flights, setFlights] = useState([]);

    const fetchFlights = () => {
        axios.get("http://localhost:8080/flights").then(res => {
            console.log(res);
            setFlights(res.data);
        })
    }

    useEffect(() => {
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

function DisplayAllFiles() {
  return (
        <div className="App">
          <header className="App-header">
            <div className="App-intro">
            <Flights   />
            </div>
          </header>
        </div>
  );
}

export default DisplayAllFiles;


/*import React from 'react';
import './App.css';

import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import SearchForm from './components/Flights/SearchForm';
import Flights from './components/Flights/Flights';






  return (
    <Router>
        <NavigationBar/>
        <Container>
            <Row>
                <Col lg={12} className={"margin-top"}>
                    <Switch>
                        <Route path="/" exact component={() => <Welcome heading={heading} quote={quote} footer={footer}/>}/>
                        <Route path="/search" exact component={SearchForm}/>
                        <Route path="/flights" exact component={Flights}/>
                    </Switch>
                </Col>
            </Row>
        </Container>
        <Footer/>
    </Router>
  );
}*/
