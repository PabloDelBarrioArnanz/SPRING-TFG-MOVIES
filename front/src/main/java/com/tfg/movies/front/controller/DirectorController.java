package com.tfg.movies.front.controller;

import com.tfg.movies.front.model.entity.Director;
import com.tfg.movies.front.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.concurrent.CompletableFuture.runAsync;

@Controller
public class DirectorController extends BaseController {

  @Autowired private DirectorService directorService;

  @PostMapping("/director")
  //@PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> createActor(@Valid @RequestBody Director director) {
    runAsync(() -> directorService.createDirector(director));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/director/{name}")
  //@PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> getActor(@PathVariable String name) {
    runAsync(() -> directorService.getDirector(name));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/director")
  //@PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> getActors() {
    runAsync(() -> directorService.getDirectors());
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/director/{name}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> deleteActor(@PathVariable String name) {
    runAsync(() -> directorService.deleteDirector(name));
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
