package com.qf.farmer.md.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qf.farmer.md.domain.Person;

public interface PersonRepository extends MongoRepository<Person, Long> {

  List<Person> findByLastname(String lastname);

  List<Person> findByFirstnameLike(String firstname);
}