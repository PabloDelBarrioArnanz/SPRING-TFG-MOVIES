package com.tfg.movies.front.comunication;

import com.tfg.movies.front.model.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
