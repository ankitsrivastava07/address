package com.address.dao.repository;

import com.address.dao.entity.StateEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
public interface StateRepository extends MongoRepository<StateEntity,String> {
    @Query(value = "{country_id: {$eq: ?0}}")
    List<StateEntity> findAllCountry(String countryId);
}
