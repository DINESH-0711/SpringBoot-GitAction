package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.School;

public interface SchoolRepository extends MongoRepository<School, String> {
}
