package org.fasttrackit.Movies.MovieService;

import org.fasttrackit.Movies.Model.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRatingRepository extends JpaRepository<MovieRating,Integer> {
}
