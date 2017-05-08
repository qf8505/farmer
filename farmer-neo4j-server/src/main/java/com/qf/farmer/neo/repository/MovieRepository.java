package com.qf.farmer.neo.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.qf.farmer.neo.domain.Movie;

@Repository
public interface MovieRepository extends GraphRepository<Movie> {
}
