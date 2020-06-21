package com.tfg.movies.front.controller;

import com.tfg.movies.front.model.entity.Actor;
import com.tfg.movies.front.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.concurrent.CompletableFuture.runAsync;

@Controller
public class ActorController extends BaseController {

  @Autowired private ActorService actorService;

  @PostMapping("/actor")
  //@PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> createActor(@Valid @RequestBody Actor actor) {
    runAsync(() -> actorService.createActor(actor));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/actor/{name}")
  //@PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> getActor(@PathVariable String name) {
    runAsync(() -> actorService.getActor(name));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/actor")
  //@PreAuthorize("hasRole('ROLE_VISITOR') OR hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> getActors() {
    runAsync(() -> actorService.getActors());
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/actor/{name}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Void> deleteActor(@PathVariable String name) {
    runAsync(() -> actorService.deleteActor(name));
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
