package com.tfg.movies.back.comunication.actor;

import com.tfg.movies.back.model.dto.ActorDTO;
import com.tfg.movies.back.model.entity.Actor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ActorMessage {

  private Actor actor;
  private ActorDTO actorDTO;

  public ActorMessage withActor(Actor actor) {
    this.actor = actor;
    return this;
  }

  public ActorMessage withActorDTO(ActorDTO actorDTO) {
    this.actorDTO = actorDTO;
    return this;
  }
}
