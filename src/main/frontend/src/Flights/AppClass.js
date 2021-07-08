import React, { Component } from "react";
import NewTask from "../Flights/Flight";
import TasksList from "../Flights/FlightList";

export default class AppClass extends Component {
  constructor(props) {
    super(props);
    this.state = {
      newFlight: {},
      allFlights: []
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange({ target }){
    const { name, value } = target;
    this.setState((prevState) => ({
      ...prevState,
      newTask: {
        ...prevState.newFlight,
        [name]: value,
        id: Date.now()
      }
    }));
  }

  handleSubmit(event){
    event.preventDefault();
    if (!this.state.newFlight.flightNum) return;
    this.setState((prevState) => ({
      allFlights: [prevState.newFlight, ...prevState.allFlights],
      newFlight: {}
    }));
  }


  render() {
    return (
      <main>
        <h1>Tasks</h1>
        <Flight
          newFlight={this.state.newFlight}
          handleChange={this.handleChange}
          handleSubmit={this.handleSubmit}
        />
        <FlightList
          allFlights={this.state.allFlights}
          handleDelete={this.handleDelete}
        />
      </main>
    );
  }
}
