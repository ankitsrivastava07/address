package com.address.dao.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "country")
public class CountryEntity {
    private String id;
    private String name;
    private String sortname;
    private String phoneCode;
}
