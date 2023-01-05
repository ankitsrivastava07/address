package com.address.service;

import java.util.Map;
public interface ApiService {
    Map<String,Object> getCountry();
    Map<String,Object> getState(String sortname);
    Map<String,Object> getCity(String stateId);
}
