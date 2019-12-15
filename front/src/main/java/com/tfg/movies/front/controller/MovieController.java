package com.tfg.movies.front.controller;

import com.tfg.movies.front.model.Movie;
import com.tfg.movies.front.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("${base.url}")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @PostMapping("/movie")
  public void createMovie(@Valid @RequestBody Movie movie) {
    movieService.createMovie(movie);
  }

  @GetMapping("{title}")
  public void getMovie(@PathVariable String title) {
    movieService.getMovie(title);
  }

  @GetMapping("/")
  public String getMovies(Model model) {
    movieService.getMovies();
    model.addAttribute("mensaje", "hola que tal?");
    return "home";
  }

  @DeleteMapping("{title}")
  public void deleteMovie(@PathVariable String title) {
    movieService.deleteMovie(title);
  }

}
