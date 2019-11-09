package com.tfg.movies.back.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private byte[] data;
    private double duration;
    private String country;
    private String gender;
    private String synopsis;
    private LocalDate premiereDate;
    @ManyToOne
    private Director director;
    @ManyToMany
    private List<Actor> actors;
    @Min(0)
    @Max(10)
    private double valoration;
    @ManyToMany
    private List<Prize> prizes;
    @OneToMany
    private List<Review> reviews;

}
