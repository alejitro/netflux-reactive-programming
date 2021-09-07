package com.alejitro.netflux.bootstrap;

import com.alejitro.netflux.domain.Movie;
import com.alejitro.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll().thenMany(
                Flux.just("Harry Potter y la piedra filosofal","Harry Potter y la camara de los secretos", "Harry Potter y la orden del fenix"
                         ,"La estrategia del caracol")
                .map(Movie::new)
                .flatMap(movieRepository::save)
        ).subscribe(null,null,()->{
            movieRepository.findAll().subscribe(System.out::println);
        });
    }
}
