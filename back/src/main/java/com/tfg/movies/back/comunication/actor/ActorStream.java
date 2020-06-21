package com.tfg.movies.back.comunication.actor;

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


  @Output(SAVE_ACTOR_RESPONSE)
  SubscribableChannel sendSaveActorResponse();

  @Output(DELETE_ACTOR_RESPONSE)
  SubscribableChannel sendDeleteActorResponse();

  @Output(READ_ACTOR_RESPONSE)
  SubscribableChannel sendReadActorResponse();

  @Input(SAVE_ACTOR_REQUEST)
  MessageChannel getActorSaveRequest();

  @Input(DELETE_ACTOR_REQUEST)
  MessageChannel getActorDeleteRequest();

  @Input(READ_ACTOR_REQUEST)
  MessageChannel getActorReadRequest();

  @Input(READ_ALL_ACTORS_REQUEST)
  MessageChannel getActorReadAllRequest();
}
