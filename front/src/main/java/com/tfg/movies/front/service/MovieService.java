package com.tfg.movies.front.service;

import com.tfg.movies.front.comunication.movie.MovieSender;
import com.tfg.movies.front.model.entity.Movie;
import com.tfg.movies.front.service.mapper.MovieMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

  private final MovieSender movieSender;
  private final MovieMapper movieMapper;

  public void createMovie(Movie movie) {
    Optional.of(movie)
      .map(movieMapper::toMovieMessage)
      .ifPresent(movieSender::sendMessageMovieToSave);
  }

  public void getMovie(@NotEmpty String title) {
    movieSender.sendMessageMovieToRead(title);
  }

  public void getMovies(Boolean sort) {
    movieSender.sendMessageMoviesToRead(sort);
  }

  public void deleteMovie(@NotEmpty String title) {
    movieSender.sendMessageMoviesToDelete(title);
  }

  public void voteMovie(Movie movieToVote) {
    movieSender.sendMessageMoviesToVote(movieToVote);
  }
}
