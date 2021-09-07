package com.alejitro.netflux.controller;

import com.alejitro.netflux.domain.Movie;
import com.alejitro.netflux.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    @GetMapping("/{id}")
    Mono<Movie> getMovieById(@PathVariable String id){
        return movieService.getMovieById(id);
    }
    @GetMapping()
    Flux<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
}
