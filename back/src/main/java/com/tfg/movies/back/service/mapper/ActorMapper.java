package com.tfg.movies.back.service.mapper;

import com.tfg.movies.back.comunication.actor.ActorMessage;
import com.tfg.movies.back.model.dto.ActorDTO;
import com.tfg.movies.back.model.entity.Actor;
import com.tfg.movies.back.model.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ActorMapper {

  public ActorMessage toMessage(Actor actor) {
    return new ActorMessage()
      .withActorDTO(toActorDTO(actor));
  }

  public ActorDTO toActorDTO(Actor actor) {
    return new ActorDTO()
      .setAge(actor.getAge())
      .setName(actor.getName())
      .setMovies(actor.getMovies().stream()
        .map(Movie::getTitle)
        .collect(Collectors.toSet()));
  }

  public Set<ActorDTO> toMovieActorDTO(Set<Actor> actors) {
    return actors.stream()
      .map(this::toMovieActorDTO)
      .collect(Collectors.toSet());
  }

  public ActorDTO toMovieActorDTO(Actor actor) {
    return new ActorDTO()
      .setAge(actor.getAge())
      .setRol(actor.getRol())
      .setName(actor.getName());
  }

  public Actor toActor(ActorMessage actorMessage) {
    return actorMessage.getActor();
  }
}
