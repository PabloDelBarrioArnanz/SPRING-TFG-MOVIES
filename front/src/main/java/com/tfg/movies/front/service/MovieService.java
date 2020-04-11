package com.tfg.movies.front.service;

import com.tfg.movies.front.comunication.movie.MessageMovieSender;
import com.tfg.movies.front.model.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

@Service
public class MovieService {

  @Autowired private MessageMovieSender messageMovieSender;

  public void createMovie(Movie movie) {
    messageMovieSender.sendMessageMovieToSave(movie);
  }

  public void getMovie(@NotEmpty String title) {
    messageMovieSender.sendMessageMovieToRead(title);
  }

  public void getMovies() {
    messageMovieSender.sendMessageMoviesToRead();
  }

  public void deleteMovie(@NotEmpty String title) {
    messageMovieSender.sendMessageMoviesToDelete(title);
  }

}
