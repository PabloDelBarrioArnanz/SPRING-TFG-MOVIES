package com.tfg.movies.front.comunication.actor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ActorStream {

  String SAVE_ACTOR_RESPONSE = "SAVE_ACTOR_RESPONSE";
  String DELETE_ACTOR_RESPONSE = "DELETE_ACTOR_RESPONSE";
  String READ_ACTOR_RESPONSE = "READ_ACTOR_RESPONSE";

  String SAVE_ACTOR_REQUEST = "SAVE_ACTOR_REQUEST";
  String DELETE_ACTOR_REQUEST = "DELETE_ACTOR_REQUEST";
  String READ_ACTOR_REQUEST = "READ_ACTOR_REQUEST";
  String READ_ALL_ACTORS_REQUEST = "READ_ALL_ACTORS_REQUEST";


  @Input(SAVE_ACTOR_RESPONSE)
  SubscribableChannel getResponseFromSavedActor();

  @Input(DELETE_ACTOR_RESPONSE)
  SubscribableChannel getResponseFromDeletedActor();

  @Input(READ_ACTOR_RESPONSE)
  SubscribableChannel getResponseFromReadActor();

  @Output(SAVE_ACTOR_REQUEST)
  MessageChannel sendRequestToSaveActor();

  @Output(DELETE_ACTOR_REQUEST)
  MessageChannel sendRequestToDeleteActor();

  @Output(READ_ACTOR_REQUEST)
  MessageChannel sendRequestToReadActor();

  @Output(READ_ALL_ACTORS_REQUEST)
  MessageChannel sendRequestToReadAllActors();
}
