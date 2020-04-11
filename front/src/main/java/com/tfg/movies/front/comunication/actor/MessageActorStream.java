package com.tfg.movies.front.comunication.actor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageActorStream {

  String ACTOR_SAVED = "ACTOR_SAVED";
  String ACTOR_DELETED = "ACTOR_DELETED";
  String ACTOR_READY_READ = "ACTOR_READY_READ";

  String ACTOR_TO_SAVE = "ACTOR_TO_SAVE";
  String ACTOR_TO_DELETE = "ACTOR_TO_DELETE";
  String ACTOR_TO_READ = "ACTOR_TO_READ";
  String ACTORS_TO_READ = "ACTORS_TO_READ";


  @Input(ACTOR_SAVED)
  SubscribableChannel getResponseFromSavedActor();

  @Input(ACTOR_DELETED)
  SubscribableChannel getResponseFromDeletedActor();

  @Input(ACTOR_READY_READ)
  SubscribableChannel getResponseFromReadActor();

  @Output(ACTOR_TO_SAVE)
  MessageChannel sendRequestToSaveActor();

  @Output(ACTOR_TO_DELETE)
  MessageChannel sendRequestToDeleteActor();

  @Output(ACTOR_TO_READ)
  MessageChannel sendRequestToReadActor();

  @Output(ACTORS_TO_READ)
  MessageChannel sendRequestToReadAllActors();

}
