package com.tfg.movies.front.controller;

import com.tfg.movies.front.model.entity.Movie;
import com.tfg.movies.front.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static java.util.concurrent.CompletableFuture.runAsync;

@Controller
@AllArgsConstructor
public class MovieController extends BaseController {

  private MovieService movieService;

  @PostMapping("/movie")
  //@PreAuthorize("hasRole('ROLE_ADMIN')")
  public CompletableFuture<Void> createMovie(@Valid @RequestBody Movie movie) {
    return completeOperation(movie, movieService::createMovie);
  }

  @GetMapping("/movie/{title}")
  //@PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public CompletableFuture<Void> getMovie(@PathVariable String title) {
    return completeOperation(title, movieService::getMovie);
  }

  @GetMapping("/movie")
  //@PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public CompletableFuture<Void> getMovies() {
    return completeOperation(Boolean.FALSE, movieService::getMovies);
  }

  @DeleteMapping("/movie/{title}")
  //@PreAuthorize("hasRole('ROLE_ADMIN')")
  public CompletableFuture<Void> deleteMovie(@PathVariable String title) {
    return completeOperation(title, movieService::deleteMovie);
  }

  private <T> CompletableFuture<Void> completeOperation(T payload, Consumer<T> operation) {
    return runAsync(() -> Optional.ofNullable(payload)
      .ifPresent(operation))
      .whenComplete((e, th) -> new ResponseEntity<>(HttpStatus.OK));
  }
}
