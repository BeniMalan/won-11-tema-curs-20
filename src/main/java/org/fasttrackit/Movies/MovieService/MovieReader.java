package org.fasttrackit.Movies.MovieService;

import org.fasttrackit.Movies.Model.Movie;
import org.fasttrackit.Movies.Model.MovieRating;
import org.fasttrackit.Movies.Model.MovieReviews;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieReader {
    String filePath = "src/main/resources/movies.txt";

    public List<Movie> readMoviesFromFile() {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                String name = data[1];
                int year = Integer.parseInt(data[2]);
                int rating = Integer.parseInt(data[4]);
                String agency = data[5];

                Movie movie = new Movie(name, year, new MovieRating(rating, agency));
                List<MovieReviews> movieReviewsList = new ArrayList<>();

                for (int i = 6; i < data.length; i += 2) {
                    String review = data[i];
                    String reviewer = data[i + 1];
                    movieReviewsList.add(new MovieReviews(review, reviewer));
                }
                movie.setReviews(movieReviewsList);
                movies.add(movie);
            }
        } catch (IOException e) {
            throw new RuntimeException("No reading", e);
        }
        return movies;
    }
}
