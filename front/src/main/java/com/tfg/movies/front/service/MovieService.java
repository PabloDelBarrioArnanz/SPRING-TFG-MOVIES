package com.tfg.movies.front.service;

import com.tfg.movies.front.comunication.movie.MovieSender;
import com.tfg.movies.front.model.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

@Service
public class MovieService {

  @Autowired private MovieSender movieSender;

  public void createMovie(Movie movie) {
    movieSender.sendMessageMovieToSave(movie);
  }

  public void getMovie(@NotEmpty String title) {
    movieSender.sendMessageMovieToRead(title);
  }

  public void getMovies() {
    movieSender.sendMessageMoviesToRead();
  }

  public void deleteMovie(@NotEmpty String title) {
    movieSender.sendMessageMoviesToDelete(title);
  }

}
