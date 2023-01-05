package com.address.dao.repository;

import com.address.dao.entity.CityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
public interface CityRepository extends MongoRepository<CityEntity,String> {
    @Query("{state_id: {$eq: ?0}}")
    List<CityEntity> findByAllCity(String stateId);
}
