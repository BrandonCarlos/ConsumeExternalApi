package com.example.Mail.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class CovidService {

    private static final String url = "https://corona-virus-world-and-india-data.p.rapidapi.com/api";
    private static final String xRapidApiKey = "719e53e7f3msh21139b6bdc2e3ffp1debf4jsn6e118089eae3";
    private static final String getxRapidApiHost = "corona-virus-world-and-india-data.p.rapidapi.com";

    @Autowired
    private RestTemplate restTemplate;

    public Object getAllCountryCovidData() {
        try {
//          Header value is set
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key", xRapidApiKey);
            headers.set("x-rapidapi-host", getxRapidApiHost);

//          Make a GET call to the RapidAPI
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            log.info("Output form rapidAPI: ", response.getBody());

            return response.getBody();

        } catch (Exception e) {
            log.error("Something went wrong while getting value from RapidAPI", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception While calling endpoint of RapidAPI for corona", e);
        }
    }
}
