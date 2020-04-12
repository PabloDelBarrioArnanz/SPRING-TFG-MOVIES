package com.tfg.movies.front.comunication.movie;

import com.tfg.movies.front.model.dto.MovieDTO;
import com.tfg.movies.front.model.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MovieMessage {

  private Movie movie;
  private MovieDTO movieDTO;

  public MovieMessage withMovie(Movie movie) {
    this.movie = movie;
    return this;
  }
}
