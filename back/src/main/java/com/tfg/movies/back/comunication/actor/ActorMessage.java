package com.tfg.movies.back.comunication.actor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tfg.movies.back.model.dto.ActorDTO;
import com.tfg.movies.back.model.entity.Actor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorMessage {

  private Actor actor;
  private ActorDTO actorDTO;

  public ActorMessage withActorDTO(ActorDTO actorDTO) {
    this.actorDTO = actorDTO;
    return this;
  }
}
