package com.alejitro.netflux.repositories;

import com.alejitro.netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie,String> {

}
