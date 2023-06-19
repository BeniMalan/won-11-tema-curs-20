package org.fasttrackit.Movies.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class MovieReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public MovieReviews(String text, String reviewer) {
        this.text = text;
        this.reviewer = reviewer;
    }
    @Column
    private String text;
     @Column
    private String reviewer;
    @ManyToOne
    @JsonIgnore
    private Movie movie;
}
