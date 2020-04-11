package com.tfg.movies.back.service;

import com.tfg.movies.back.comunication.actor.ActorMessage;
import com.tfg.movies.back.comunication.actor.MessageActorSender;
import com.tfg.movies.back.repository.ActorRepository;
import com.tfg.movies.back.service.mapper.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActorService {

  @Autowired private ActorRepository actorRepository;
  @Autowired private ActorMapper actorMapper;
  @Autowired private MessageActorSender messageActorSender;

  public void saveActor(ActorMessage actorMessage) {
    Optional.of(actorMessage)
      .map(actorMapper::toActor)
      .map(actor -> actorRepository.save(actor))
      .map(actorMapper::toMessage)
      .ifPresent(messageToSend -> messageActorSender.sendMessageActorSaved(messageToSend));
  }

  public void readActorsByName(String name) {
    actorRepository.findByName(name)
      .parallelStream()
      .map(actorMapper::toMessage)
      .forEach(message -> messageActorSender.sendMessageActorsRead(message));
  }

  public void readAllActors() {
    actorRepository.findAll()
      .parallelStream()
      .map(actorMapper::toMessage)
      .forEach(message -> messageActorSender.sendMessageActorsRead(message));
  }

  public void deleteActorByName(String name) {
    Optional.of(name)
      .map(actorRepository::deleteByName)
      .map(id -> id >= 0)
      .ifPresent(id -> messageActorSender.sendMessageActorDeleted(id));
  }
}
