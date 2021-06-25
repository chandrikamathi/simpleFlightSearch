package com.example.demo;

import com.example.demo.controller.FlightController;
import com.example.demo.model.Flight;
import com.example.demo.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FlightControllerTdd {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;

    @BeforeEach
    void setMockOutput(){
        Flight f1 = new Flight();
        Flight f2 = new Flight();
        List<Flight> list = new ArrayList<Flight>();
        list.add(f1);
        list.add(f2);

        when(flightService.getAllFlights())
                .thenReturn(list);
    }

    @Test
    void fetchFlights_getAllFlights(){
        assertEquals(flightController.getAllFlights().getBody().size(), 2);
    }

    @Test
    void testHttp_restApi() throws MalformedURLException {
        ResponseEntity<List<Flight>> response = restTemplate.exchange(
                new URL("http://localhost:" + port + "/flights").toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Flight>>(){});
        assertNotNull(response.getBody());
        assertEquals(12, response.getBody().size());
    }


}

