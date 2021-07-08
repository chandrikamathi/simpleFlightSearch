import React, { useState } from 'react';
import {Flight} from './Flight.js';
import axios from 'axios';

export const SearchForm = () => {
  const [search, setSearch] = useState({
                                         flightNum: '',
                                         origin: '',
                                         destination: '',
                                         date: ''
                                       }
);

     const [data, setData] = useState([]);



  const handleChange = ({ target }) => {
    const name = target.name;
    const value = target.value;
    setSearch({ ...search,
      [name]: value
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
   let axiosConfig = {
     headers: {
         'Content-Type': 'application/json;charset=UTF-8',
         "Access-Control-Allow-Origin": "*",
     }
   };
    alert(JSON.stringify(search, '', 2));
    const data = JSON.stringify(search);
    axios.post("http://localhost:8080/search", data, axiosConfig)
      .then(res => {
            console.log(res);
            setData(res.data);
      })
  };

  return (
      <div>
        <div>
            <form>
            <label>
              <input
                value={search.flightNum|| ''}
                name="flightNum"
                type="text"
                placeholder="Flight Num"
                onChange={handleChange}
              />
              </label>
              <label>
              <input
                value={search.origin || ''}
                type="text"
                name="origin"
                placeholder="Origin"
                onChange={handleChange}
              />
              </label>
              <label>
              <input
                value={search.destination || ''}
                type="text"
                name="destination"
                placeholder="destination"
                onChange={handleChange}
              />
               </label>
                <label>
               <input
                  value={search.date || ''}
                  type="date"
                  name="Date"
                  onChange={handleChange}
               />
                </label>

              <button type="submit" onClick={handleSubmit}>Submit</button>
            </form>
        </div>
        <div>{data.map((flight, index) => {
        return (
            <div key={index}>
                <h2>Flight Number: { flight.flightNumber}</h2>
                <p>Carrier:{flight.carrier}</p>
                <p>{flight.origin} -> {flight.destination}</p>
                <p>Departure: {flight.departure}</p>
                <p>Arrival: {flight.arrival}</p>
            </div>
        );
        })}</div>
    </div>
  );
}

export default SearchForm;
