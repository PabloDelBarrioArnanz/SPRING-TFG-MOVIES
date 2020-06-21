package com.tfg.movies.back.service;

import com.tfg.movies.back.comunication.actor.ActorMessage;
import com.tfg.movies.back.comunication.actor.ActorSender;
import com.tfg.movies.back.comunication.error.ErrorMessage;
import com.tfg.movies.back.comunication.error.ErrorSender;
import com.tfg.movies.back.repository.ActorRepository;
import com.tfg.movies.back.service.mapper.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.tfg.movies.back.service.Util.peek;

@Service
public class ActorService {

  @Autowired private ActorRepository actorRepository;
  @Autowired private ActorMapper actorMapper;
  @Autowired private ActorSender actorSender;
  @Autowired private ErrorSender errorSender;

  public void saveActor(ActorMessage actorMessage) {
    Optional.of(actorMessage)
      .map(actorMapper::toActor)
      .map(actor -> actorRepository.save(actor))
      .map(actorMapper::toMessage)
      .map(messageToSend -> actorSender.sendMessageActorSaved(messageToSend))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage().withError("Impossible to save this actor")));
  }

  public void readActorByName(String name) {
    Optional.ofNullable(name)
      .map(actorRepository::findByName)
      .map(actorMapper::toMessage)
      .map(message -> actorSender.sendMessageActorRead(message))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage().withError("Impossible to read this actor")));
  }

  public void readAllActors() {
    actorRepository.findAll()
      .parallelStream()
      .map(actorMapper::toMessage)
      .forEach(message -> actorSender.sendMessageActorRead(message));
  }

  public void deleteActorByName(String name) {
    Optional.of(name)
      .map(actorRepository::findByName)
      .map(peek(actorRepository::delete))
      .map(id -> actorSender.sendMessageActorDeleted(Boolean.TRUE))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage().withError("Impossible to delete this actor")));
  }
}
