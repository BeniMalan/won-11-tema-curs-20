package org.fasttrackit.Movies.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @Column
    private String name;
    @Column
    private int yyear;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private MovieRating movieRating;
    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MovieReviews> reviews;


    public Movie(String name, int yyear, MovieRating movieRating) {
        this.name = name;
        this.yyear = yyear;
        this.movieRating = movieRating;
    }

    public Movie(int id) {
        this.ID = ID;
    }
}