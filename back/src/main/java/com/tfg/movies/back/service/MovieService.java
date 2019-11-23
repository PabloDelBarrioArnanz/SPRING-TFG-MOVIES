package com.tfg.movies.back.service;

import com.tfg.movies.back.comunication.Message;
import com.tfg.movies.back.comunication.MessageSender;
import com.tfg.movies.back.entity.Movie;
import com.tfg.movies.back.mapper.MovieMapper;
import com.tfg.movies.back.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MovieService {

  @Autowired private MovieRepository movieRepository;
  @Autowired private MessageSender messageSender;
  @Autowired private MovieMapper mapper;

  public void saveMovie(Movie movie) {
    movieRepository.save(movie);
  }

  public void saveMovie(Message message) {
    messageSender.sendMessageMovieSaved(
      movieRepository.deleteByTitle(mapper.toMovie(message).getTitle()));
  }

  public void readMoviesByTitle(String title) {
    messageSender.sendMessageMoviesReadByTitle(
      movieRepository.findByTitle(title)
        .parallelStream()
        .map(MovieMapper::toMessage)
        .collect(Collectors.toList())
    );
  }

  public void readAllMovies() {
    messageSender.sendMessageMoviesRead(
      movieRepository.findAll()
        .parallelStream()
        .map(MovieMapper::toMessage)
        .collect(Collectors.toList())
    );
  }

  public void deleteMovieByTitle(String title) {
    messageSender.sendMessageMovieDeleted(movieRepository.deleteByTitle(title));
  }

}
