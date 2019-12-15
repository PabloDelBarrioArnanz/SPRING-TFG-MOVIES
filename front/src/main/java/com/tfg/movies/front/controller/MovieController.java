package com.tfg.movies.front.controller;

import com.tfg.movies.front.model.Movie;
import com.tfg.movies.front.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("${base.url}")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @PostMapping("create/movie")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void createMovie(@Valid @RequestBody Movie movie) {
    movieService.createMovie(movie);
  }

  @GetMapping("/{title}")
  @PreAuthorize("hasRole('ROLE_VISITOR')")
  public void getMovie(@PathVariable String title) {
    movieService.getMovie(title);
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ROLE_VISITOR')")
  public String getMovies(Model model) {
    movieService.getMovies();
    model.addAttribute("mensaje", "hola que tal?");
    return "home";
  }

  @DeleteMapping("/delete/{title}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void deleteMovie(@PathVariable String title) {
    movieService.deleteMovie(title);
  }

}
