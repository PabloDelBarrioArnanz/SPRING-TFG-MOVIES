package com.tfg.movies.front.controller;

import com.tfg.movies.front.comunication.MessageSender;
import com.tfg.movies.front.mapper.MoviesMapper;
import com.tfg.movies.front.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MovieController {

  @Autowired private MessageSender messageSender;
  @Autowired private MoviesMapper moviesMapper;

  @PostMapping
  public void createMovie(@RequestBody Movie movie) {
    messageSender.sendMessageMovieToSave(moviesMapper.toMessage(movie));
  }

  @GetMapping("/movie/{title}")
  public void getMovie(@PathVariable String title) {
    messageSender.sendMessageMovieToRead(moviesMapper.toMessage(title));
  }

  @GetMapping("/all")
  public void getMovies() {
    messageSender.sendMessageMovieToRead(moviesMapper.toMessage("all"));
  }

  @DeleteMapping("/movie/{title}")
  public void deleteMovie(@PathVariable String title) {
    messageSender.sendMessageMoviesToDelete(moviesMapper.toMessage(title));
  }

}
