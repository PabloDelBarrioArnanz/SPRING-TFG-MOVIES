package com.tfg.movies.front.controller;

import com.tfg.movies.front.model.entity.Movie;
import com.tfg.movies.front.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.function.Consumer;

import static java.util.concurrent.CompletableFuture.runAsync;

@Controller
@AllArgsConstructor
public class MovieController extends BaseController {

  private final MovieService movieService;

  @GetMapping("/no-restricted/movie/{title}")
  @PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public CompletionStage<ResponseEntity<Void>> getMovie(@PathVariable String title) {
    return completeOperation(title, movieService::getMovie);
  }

  @GetMapping("/no-restricted/movie")
  @PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public CompletionStage<ResponseEntity<Void>> getMovies() {
    return completeOperation(Boolean.FALSE, movieService::getMovies);
  }

  @GetMapping("/no-restricted/movie/sort")
  @PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public CompletionStage<ResponseEntity<Void>> getSortMovies() {
    return completeOperation(Boolean.TRUE, movieService::getMovies);
  }

  @PostMapping("/no-restricted/vote/movie")
  @PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public CompletionStage<ResponseEntity<Void>> voteMovie(@RequestBody Movie movieToVote) {
    return completeOperation(movieToVote, movieService::voteMovie);
  }

  //ADMIN ENDPOINTS
  @DeleteMapping("/restricted/movie/{title}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public CompletionStage<ResponseEntity<Void>> deleteMovie(@PathVariable String title) {
    return completeOperation(title, movieService::deleteMovie);
  }

  @PostMapping("/restricted/movie")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public CompletionStage<ResponseEntity<Void>> createMovie(@Valid @RequestBody Movie movie) {
    return completeOperation(movie, movieService::createMovie);
  }

  private <T> CompletionStage<ResponseEntity<Void>> completeOperation(T payload, Consumer<T> operation) {
    return runAsync(() -> Optional.ofNullable(payload)
      .ifPresent(operation))
      .thenApplyAsync(op -> new ResponseEntity<>(HttpStatus.OK));
  }
}
