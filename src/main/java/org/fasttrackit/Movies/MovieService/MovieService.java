package org.fasttrackit.Movies.MovieService;

import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.fasttrackit.Movies.Model.Movie;
import org.fasttrackit.Movies.Model.MovieRating;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
@Service
@RequiredArgsConstructor

public class MovieService {
        private final MovieReader movieReader;

        private final MovieRepository movieRepository;

        @PostConstruct
        public void init() {
            List<Movie> myListOfMovies = null;

            myListOfMovies = movieReader.readMoviesFromFile ();

            movieRepository.saveAll ( myListOfMovies );
        }
      public  List<Movie> getAllMovies() {
            List<Movie> movieList = movieRepository.findAll ().stream ().toList ();
            return movieList;
        }
    }

