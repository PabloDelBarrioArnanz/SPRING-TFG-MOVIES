package com.tfg.movies.back.comunication.director;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageDirectorStream {

  String DIRECTOR_SAVED = "DIRECTOR_SAVED";
  String DIRECTOR_DELETED = "DIRECTOR_DELETED";
  String DIRECTOR_READY_READ = "DIRECTOR_READY_READ";
  String DIRECTORS_READY_READ = "DIRECTORS_READY_READ";

  String DIRECTOR_TO_SAVE = "DIRECTOR_TO_SAVE";
  String DIRECTOR_TO_DELETE = "DIRECTOR_TO_DELETE";
  String DIRECTOR_TO_READ = "DIRECTOR_TO_READ";
  String DIRECTORS_TO_READ = "DIRECTORS_TO_READ";


  @Output(DIRECTOR_SAVED)
  SubscribableChannel outboundSaved();

  @Output(DIRECTOR_DELETED)
  SubscribableChannel outboundDeleted();

  @Output(DIRECTOR_READY_READ)
  SubscribableChannel outboundRead();

  @Output(DIRECTORS_READY_READ)
  SubscribableChannel outboundsRead();


  @Input(DIRECTOR_TO_SAVE)
  MessageChannel inboundToSave();

  @Input(DIRECTOR_TO_DELETE)
  MessageChannel inboundToDelete();

  @Input(DIRECTOR_TO_READ)
  MessageChannel inboundToRead();

  @Input(DIRECTORS_TO_READ)
  MessageChannel inboundsToRead();

}
