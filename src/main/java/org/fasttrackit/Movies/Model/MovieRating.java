package org.fasttrackit.Movies.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name = "movie_ratings")
public class MovieRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int rating;
    @Column
    private String agency;

    @OneToOne(mappedBy = "movieRating")
    private Movie movie;

    public MovieRating(int rating, String agency) {
        this.rating = rating;
        this.agency = agency;
    }
}
