package org.fasttrackit.Movies.Controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.Movies.Model.Movie;
import org.fasttrackit.Movies.MovieService.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
@GetMapping("/All")
List<Movie>getall() {
    return movieService.getAllMovies ();

   }
}



