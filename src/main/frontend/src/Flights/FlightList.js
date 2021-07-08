import React from "react";

export default function FlightList(allFlights) {
  return (
    <ul>
      {allFlights.map(({ flightNum, origin, destination, date }) => (
        <li key={flightNum}>
          <div>
            <h2>{origin} to {destination}</h2>

          </div>
          {!date ? null : <p>{date}</p>}
        </li>
      ))}
    </ul>
  );
}
