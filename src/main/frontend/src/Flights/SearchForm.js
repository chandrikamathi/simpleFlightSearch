import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import { v4 as uuidv4 } from 'uuid';

const SearchForm = (props) => {
  const [search, setFlight] = useState({
    flightNum: props.flight ? props.flight.flightNum : '',
    origin: props.flight ? props.flight.origin : '',
    destination: props.flight ? props.flight.destination : '',
    date: props.flight ? props.flight.date : ''
  });

  const [errorMsg, setErrorMsg] = useState('');
  const { flightNum, origin, destination, date } = search;

  const handleOnSubmit = (event) => {
    event.preventDefault();
    const values = [flightNum, origin, destination, date];
    let errorMsg = '';

    const allFieldsFilled = values.every((field) => {
      const value = `${field}`.trim();
      return value !== '' && value !== '0';
    }
    axios.post('https://localhost:8080/search', search)
            .then(response => this.setState({ articleId: response.data.id }));

    );

    if (allFieldsFilled) {
      const search = {
        flightNum, origin, destination, date
      };
      props.handleOnSubmit(search);
    } else {
      errorMsg = 'Please fill out all the fields.';
    }
    setErrorMsg(errorMsg);
  };

  const handleInputChange = (event) => {
    const { flightNum, value } = event.target;
    switch (flightNum) {
      case 'origin':
        if (value === '' || parseInt(value) === +value) {
          setSearch((prevState) => ({
            ...prevState,
            [name]: value
          }));
        }
        break;
      case 'destination':
        if (value === '' || value.match(/^\d{1,}(\.\d{0,2})?$/)) {
          setSearch((prevState) => ({
            ...prevState,
            [name]: value
          }));
        }
        break;
      default:
        setSearch((prevState) => ({
          ...prevState,
          [name]: value
        }));
    }
  };

  return (
    <div className="main-form">
      {errorMsg && <p className="errorMsg">{errorMsg}</p>}
      <Form onSubmit={handleOnSubmit}>
        <Form.Group controlId="flightNum">
          <Form.Label>Flight Number</Form.Label>
          <Form.Control
            className="input-control"
            type="number"
            name="flightNum"
            value={flightNum}
            placeholder="Enter Flight Number"
            onChange={handleInputChange}
          />
        </Form.Group>
        <Form.Group controlId="origin">
          <Form.Label>origin</Form.Label>
          <Form.Control
            className="input-control"
            type="text"
            name="origin"
            value={origin}
            placeholder="Enter origin"
            onChange={handleInputChange}
          />
        </Form.Group>
        <Form.Group controlId="destination">
          <Form.Label>Quantity</Form.Label>
          <Form.Control
            className="input-control"
            type="text"
            name="destination"
            value={quantity}
            placeholder="Enter destination"
            onChange={handleInputChange}
          />
        </Form.Group>
        <Form.Group controlId="date">
          <Form.Label>Date</Form.Label>
          <Form.Control
            className="input-control"
            type="text"
            name="date"
            value={price}
            placeholder="Enter date"
            onChange={handleInputChange}
          />
        </Form.Group>
        <Button variant="primary" type="submit" className="submit-btn">
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default SearchForm;