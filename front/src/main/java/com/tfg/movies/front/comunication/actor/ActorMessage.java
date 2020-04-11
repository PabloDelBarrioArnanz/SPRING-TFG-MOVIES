package com.tfg.movies.front.comunication.actor;

import com.tfg.movies.front.model.dto.ActorDTO;
import com.tfg.movies.front.model.entity.Actor;
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
}
