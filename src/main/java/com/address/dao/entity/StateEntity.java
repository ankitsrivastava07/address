package com.address.dao.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "state")
public class StateEntity {
    @Id
    private String id;
    private String name;
    private String country_id;
}
