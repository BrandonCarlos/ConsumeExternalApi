package com.example.Mail.controller;

import com.example.Mail.service.CovidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
@RequiredArgsConstructor //Constructor in format of annotation
public class CovidController {

    private final CovidService covidService;

    @GetMapping("/get-all-country-covid-data")
    public ResponseEntity<?> callRapidEndpointToGetCovidData() {
        return ResponseEntity.ok(covidService.getAllCountryCovidData());
    }


}
