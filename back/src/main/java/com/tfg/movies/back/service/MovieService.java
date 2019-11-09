package com.tfg.movies.back.service;

import com.tfg.movies.back.entity.Movie;
import com.tfg.movies.back.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired private MovieRepository movieRepository;

  public void saveMovie(Movie movie) {
    movieRepository.save(movie);
  }

}
