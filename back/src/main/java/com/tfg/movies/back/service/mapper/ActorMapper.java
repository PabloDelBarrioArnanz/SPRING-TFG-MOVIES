package com.tfg.movies.back.service.mapper;

import com.tfg.movies.back.comunication.actor.ActorMessage;
import com.tfg.movies.back.model.dto.ActorDTO;
import com.tfg.movies.back.model.entity.Actor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ActorMapper {

  public ActorMessage toMessage(Actor actor) {
    return new ActorMessage()
      .withActorDTO(toActorDTO(actor));
  }

  public Set<ActorDTO> toActorDTO(Set<Actor> actors) {
    return actors.stream()
      .map(this::toActorDTO)
      .collect(Collectors.toSet());
  }

  public ActorDTO toActorDTO(Actor actor) {
    return new ActorDTO()
      .setAge(actor.getAge())
      .setName(actor.getName());
  }

  public Actor toActor(ActorMessage actorMessage) {
    return actorMessage.getActor();
  }
}
