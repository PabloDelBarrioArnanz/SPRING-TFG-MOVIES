package com.tfg.movies.front.service.mapper;

import com.tfg.movies.front.comunication.actor.ActorMessage;
import com.tfg.movies.front.model.dto.ActorDTO;
import com.tfg.movies.front.model.entity.Actor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ActorMapper {

  public ActorMessage toActorMessage(Actor actor) {
    return new ActorMessage().withActor(actor);
  }

  public ActorMessage toActorMessage(String name) {
    ActorMessage actorMessage = new ActorMessage();
    Optional.of(new Actor())
      .map(actor -> actor.setName(name))
      .ifPresent(actorMessage::withActor);

    return actorMessage;
  }

  public Actor toActor(ActorMessage actorMessage) {
    return actorMessage.getActor();
  }

  public ActorDTO toActorDTO(ActorMessage actorMessage) {
    return actorMessage.getActorDTO();
  }

}
