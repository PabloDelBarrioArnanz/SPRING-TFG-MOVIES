package com.tfg.movies.back.comunication;

import com.tfg.movies.back.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Message {

  private Movie movie;

  public Message setMovie(Movie movie) {
    this.movie = movie;
    return this;
  }

}
