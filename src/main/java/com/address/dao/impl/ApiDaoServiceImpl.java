package com.address.dao.impl;

import com.address.dao.ApiDaoService;
import com.address.dao.entity.CityEntity;
import com.address.dao.entity.CountryEntity;
import com.address.dao.entity.StateEntity;
import com.address.dao.repository.CityRepository;
import com.address.dao.repository.CountryRepository;
import com.address.dao.repository.StateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class ApiDaoServiceImpl implements ApiDaoService {
    @Autowired
    CountryRepository repository;
    @Autowired
    StateRepository stateRepository;
    @Autowired
    CityRepository cityRepository;
    @Override
    public Map<String, Object> save(List<Map<String, Object>> data) {
        ObjectMapper mapper = new ObjectMapper();
        List<CountryEntity> list = data.stream().map(entity -> {
            CountryEntity country = mapper.convertValue(entity, CountryEntity.class);
            country = repository.save(country);
            return country;
        }).collect(Collectors.toList());
        Map<String, Object> map = new HashMap<>();
        map.put("Success", Boolean.TRUE);
        map.put("country", list);
        return map;
    }

    @Override
    public Map<String, Object> saveState(List<Map<String, Object>> states) {
        Map<String, Object> data = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        List<StateEntity> statesRes = states.stream().map(state -> {
            StateEntity entity = mapper.convertValue(state, StateEntity.class);
            return stateRepository.save(entity);
        }).collect(Collectors.toList());
        data.put("Success", Boolean.TRUE);
        data.put("data", statesRes);
        return data;
    }

    @Override
    public Map<String, Object> saveCity(List<Map<String, Object>> cities) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();
        List<CityEntity> citiesRes = cities.stream().map(city -> {
            CityEntity entity = mapper.convertValue(city, CityEntity.class);
            return cityRepository.save(entity);
        }).collect(Collectors.toList());
        data.put("data", citiesRes);
        data.put("success", Boolean.TRUE);
        return data;
    }
}
