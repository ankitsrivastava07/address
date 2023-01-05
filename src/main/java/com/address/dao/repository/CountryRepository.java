package com.address.dao.repository;

import com.address.dao.entity.CountryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<CountryEntity,String> {
}
