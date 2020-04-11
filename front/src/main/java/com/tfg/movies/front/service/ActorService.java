package com.tfg.movies.front.service;

import com.tfg.movies.front.comunication.actor.MessageActorSender;
import com.tfg.movies.front.model.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

@Service
public class ActorService {

  @Autowired private MessageActorSender messageActorSender;

  public void createActor(Actor actor) {
    messageActorSender.sendMessageActorToSave(actor);
  }

  public void getActor(@NotEmpty String name) {
    messageActorSender.sendMessageActorToRead(name);
  }

  public void getActors() {
    messageActorSender.sendMessageActorsToRead();
  }

  public void deleteActor(@NotEmpty String name) {
    messageActorSender.sendMessageActorsToDelete(name);
  }

}
