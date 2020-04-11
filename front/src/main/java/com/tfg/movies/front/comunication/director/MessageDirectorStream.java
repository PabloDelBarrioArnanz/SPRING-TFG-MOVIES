package com.tfg.movies.front.comunication.director;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageDirectorStream {

  String DIRECTOR_SAVED = "DIRECTOR_SAVED";
  String DIRECTOR_DELETED = "DIRECTOR_DELETED";
  String DIRECTOR_READY_READ = "DIRECTOR_READY_READ";

  String DIRECTOR_TO_SAVE = "DIRECTOR_TO_SAVE";
  String DIRECTOR_TO_DELETE = "DIRECTOR_TO_DELETE";
  String DIRECTOR_TO_READ = "DIRECTOR_TO_READ";
  String DIRECTORS_TO_READ = "DIRECTORS_TO_READ";


  @Input(DIRECTOR_SAVED)
  SubscribableChannel getResponseFromSavedDirector();

  @Input(DIRECTOR_DELETED)
  SubscribableChannel getResponseFromDeletedDirector();

  @Input(DIRECTOR_READY_READ)
  SubscribableChannel getResponseFromReadDirector();

  @Output(DIRECTOR_TO_SAVE)
  MessageChannel sendRequestToSaveDirector();

  @Output(DIRECTOR_TO_DELETE)
  MessageChannel sendRequestToDeleteDirector();

  @Output(DIRECTOR_TO_READ)
  MessageChannel sendRequestToReadDirector();

  @Output(DIRECTORS_TO_READ)
  MessageChannel sendRequestToReadAllDirectors();

}
