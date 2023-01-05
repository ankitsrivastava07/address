package com.address.controller;

import com.address.dao.ApiDaoService;
import com.address.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v1/country")
public class ApiController {
    @Autowired
    ApiDaoService apiDaoService;
    @Autowired
    ApiService apiService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCountry(@RequestBody List<Map<String, Object>> countries) {
        Map<String, Object> data = apiDaoService.save(countries);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/save-state")
    public ResponseEntity<?> saveState(@RequestBody List<Map<String, Object>> states) {
        return new ResponseEntity<>(apiDaoService.saveState(states), HttpStatus.OK);
    }

    @PostMapping("/save-city")
    public ResponseEntity<?> saveCity(@RequestBody List<Map<String, Object>> city) {
        return new ResponseEntity<>(apiDaoService.saveCity(city), HttpStatus.OK);
    }
    @GetMapping({"","/"})
    public ResponseEntity<?> getCountry() {
        return new ResponseEntity<>(apiService.getCountry(),HttpStatus.OK);
    }
    @GetMapping("/{countryId}/state")
    public ResponseEntity<?> getCountry(@PathVariable String countryId) {
        return new ResponseEntity<>(apiService.getState(countryId), HttpStatus.OK);
    }
    @GetMapping("/state/{stateId}/city")
    public ResponseEntity<?> getCity(@PathVariable String stateId){
       return new ResponseEntity<>(apiService.getCity(stateId),HttpStatus.OK);
    }
}
