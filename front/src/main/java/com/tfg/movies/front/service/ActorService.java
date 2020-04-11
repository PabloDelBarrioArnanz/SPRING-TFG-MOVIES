package com.tfg.movies.front.service;

import com.tfg.movies.front.comunication.actor.ActorSender;
import com.tfg.movies.front.model.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

@Service
public class ActorService {

  @Autowired private ActorSender actorSender;

  public void createActor(Actor actor) {
    actorSender.sendMessageActorToSave(actor);
  }

  public void getActor(@NotEmpty String name) {
    actorSender.sendMessageActorToRead(name);
  }

  public void getActors() {
    actorSender.sendMessageActorsToRead();
  }

  public void deleteActor(@NotEmpty String name) {
    actorSender.sendMessageActorsToDelete(name);
  }

}
