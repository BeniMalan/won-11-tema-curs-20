package org.fasttrackit.Movies.MovieService;

import org.fasttrackit.Movies.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

}
