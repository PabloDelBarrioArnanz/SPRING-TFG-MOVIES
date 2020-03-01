package com.tfg.movies.front.service;

import com.tfg.movies.front.comunication.MessageSender;
import com.tfg.movies.front.model.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

@Service
public class MovieService {

  @Autowired private MessageSender messageSender;

  public void createMovie(Movie movie) {
    messageSender.sendMessageMovieToSave(movie);
  }

  public void getMovie(@NotEmpty String title) {
    messageSender.sendMessageMovieToRead(title);
  }

  public void getMovies() {
    messageSender.sendMessageMoviesToRead();
  }

  public void deleteMovie(@NotEmpty String title) {
    messageSender.sendMessageMoviesToDelete(title);
  }

}
