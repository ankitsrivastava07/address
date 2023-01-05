package com.address.dao;

import java.util.List;
import java.util.Map;
public interface ApiDaoService {
    Map<String,Object> save(List<Map<String,Object>> data);

    Map<String,Object> saveState(List<Map<String, Object>> states);

    Map<String,Object> saveCity(List<Map<String, Object>> cities);
}
