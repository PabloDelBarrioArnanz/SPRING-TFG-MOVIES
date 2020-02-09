package com.tfg.movies.front.controller;

import com.tfg.movies.front.model.Movie;
import com.tfg.movies.front.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("${controller.movie.endpoint}")
public class MovieController {

  @Autowired private MovieService movieService;

  @PostMapping("create/movie")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void createMovie(@Valid @RequestBody Movie movie) {
    movieService.createMovie(movie);
  }

  @GetMapping("/{title}")
  @PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public void getMovie(@PathVariable String title) {
    movieService.getMovie(title);
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public String getMovies() {
    movieService.getMovies();
    return "AllMoviesView";
  }

  @DeleteMapping("/delete/{title}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void deleteMovie(@PathVariable String title) {
    movieService.deleteMovie(title);
  }

}
