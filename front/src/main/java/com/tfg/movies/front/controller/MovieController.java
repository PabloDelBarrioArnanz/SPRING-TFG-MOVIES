package com.tfg.movies.front.controller;

import com.tfg.movies.front.model.entity.Movie;
import com.tfg.movies.front.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.concurrent.CompletableFuture.runAsync;


@Controller
@RequestMapping("${controller.movie.endpoint}")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @PostMapping("/create/movie")
  //@PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> createMovie(@Valid @RequestBody Movie movie) {
    runAsync(() -> movieService.createMovie(movie));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/{title}")
  //@PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> getMovie(@PathVariable String title) {
    runAsync(() -> movieService.getMovie(title));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/all")
  //@PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> getMovies() {
    runAsync(() -> movieService.getMovies());
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/delete/{title}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> deleteMovie(@PathVariable String title) {
    runAsync(() -> movieService.deleteMovie(title));
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
