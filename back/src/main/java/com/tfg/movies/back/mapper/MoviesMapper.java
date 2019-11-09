package com.tfg.movies.back.mapper;

import com.tfg.movies.back.comunication.Message;
import com.tfg.movies.back.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MoviesMapper {

  public Message toMessage(Movie movie) {
    return new Message().setMovie(movie);
  }

  public Movie toMovie(Message message) {
    return message.getMovie();
  }

}
