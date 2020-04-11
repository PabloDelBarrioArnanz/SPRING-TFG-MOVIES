package com.tfg.movies.back.comunication.actor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageActorStream {

  String ACTOR_SAVED = "ACTOR_SAVED";
  String ACTOR_DELETED = "ACTOR_DELETED";
  String ACTOR_READY_READ = "ACTOR_READY_READ";
  String ACTORS_READY_READ = "ACTORS_READY_READ";

  String ACTOR_TO_SAVE = "ACTOR_TO_SAVE";
  String ACTOR_TO_DELETE = "ACTOR_TO_DELETE";
  String ACTOR_TO_READ = "ACTOR_TO_READ";
  String ACTORS_TO_READ = "ACTORS_TO_READ";


  @Output(ACTOR_SAVED)
  SubscribableChannel outboundSaved();

  @Output(ACTOR_DELETED)
  SubscribableChannel outboundDeleted();

  @Output(ACTOR_READY_READ)
  SubscribableChannel outboundRead();

  @Output(ACTORS_READY_READ)
  SubscribableChannel outboundsRead();


  @Input(ACTOR_TO_SAVE)
  MessageChannel inboundToSave();

  @Input(ACTOR_TO_DELETE)
  MessageChannel inboundToDelete();

  @Input(ACTOR_TO_READ)
  MessageChannel inboundToRead();

  @Input(ACTORS_TO_READ)
  MessageChannel inboundsToRead();

}
