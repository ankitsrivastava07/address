package com.address.dao.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "city")
public class CityEntity {
    private String id;
    private String name;
    private String state_id;
}
