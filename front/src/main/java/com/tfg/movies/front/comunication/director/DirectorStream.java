package com.tfg.movies.front.comunication.director;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DirectorStream {

  String SAVE_DIRECTOR_RESPONSE = "SAVE_DIRECTOR_RESPONSE";
  String DELETE_DIRECTOR_RESPONSE = "DELETE_DIRECTOR_RESPONSE";
  String READ_DIRECTOR_RESPONSE = "READ_DIRECTOR_RESPONSE";

  String SAVE_DIRECTOR_REQUEST = "SAVE_DIRECTOR_REQUEST";
  String DELETE_DIRECTOR_REQUEST = "DELETE_DIRECTOR_REQUEST";
  String READ_DIRECTOR_REQUEST = "READ_DIRECTOR_REQUEST";
  String READ_ALL_DIRECTORS_REQUEST = "READ_ALL_DIRECTORS_REQUEST";


  @Input(SAVE_DIRECTOR_RESPONSE)
  SubscribableChannel getResponseFromSavedDirector();

  @Input(DELETE_DIRECTOR_RESPONSE)
  SubscribableChannel getResponseFromDeletedDirector();

  @Input(READ_DIRECTOR_RESPONSE)
  SubscribableChannel getResponseFromReadDirector();

  @Output(SAVE_DIRECTOR_REQUEST)
  MessageChannel sendRequestToSaveDirector();

  @Output(DELETE_DIRECTOR_REQUEST)
  MessageChannel sendRequestToDeleteDirector();

  @Output(READ_DIRECTOR_REQUEST)
  MessageChannel sendRequestToReadDirector();

  @Output(READ_ALL_DIRECTORS_REQUEST)
  MessageChannel sendRequestToReadAllDirectors();

}
