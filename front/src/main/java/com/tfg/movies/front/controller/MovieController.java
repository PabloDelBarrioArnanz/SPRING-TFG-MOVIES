package com.tfg.movies.front.controller;

import com.tfg.movies.front.model.Movie;
import com.tfg.movies.front.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("${base.url}" + "/movie")
public class MovieController {

  @Autowired private MovieService movieService;

  @PostMapping
  public void createMovie(@Valid @RequestBody Movie movie) {
    movieService.createMovie(movie);
  }

  @GetMapping("{title}")
  public void getMovie(@PathVariable String title) {
    movieService.getMovie(title);
  }

  @GetMapping
  public void getMovies() {
    movieService.getMovies();
  }

  @DeleteMapping("{title}")
  public void deleteMovie(@PathVariable String title) {
    movieService.deleteMovie(title);
  }

}
