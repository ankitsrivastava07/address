package com.address.service.impl;

import com.address.dao.repository.CityRepository;
import com.address.dao.repository.CountryRepository;
import com.address.dao.repository.StateRepository;
import com.address.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    StateRepository stateRepository;
    @Autowired
    CityRepository cityRepository;

    @Override
    public Map<String, Object> getCountry() {
        Map<String, Object> countries = new HashMap<>();
        countries.put("country", countryRepository.findAll());
        return countries;
    }

    @Override
    public Map<String, Object> getState(String countryId) {
        Map<String, Object> states = new HashMap<>();
        states.put("state", stateRepository.findAllCountry(countryId));
        return states;
    }

    @Override
    public Map<String, Object> getCity(String stateId) {
        Map<String, Object> data = new HashMap<>();
        data.put("city", cityRepository.findByAllCity(stateId));
        return data;
    }
}
