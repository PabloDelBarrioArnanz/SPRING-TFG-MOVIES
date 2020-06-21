package com.tfg.movies.back.comunication.director;

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


  @Output(SAVE_DIRECTOR_RESPONSE)
  SubscribableChannel sendSaveDirectorResponse();

  @Output(DELETE_DIRECTOR_RESPONSE)
  SubscribableChannel sendDeleteDirectorResponse();

  @Output(READ_DIRECTOR_RESPONSE)
  SubscribableChannel sendReadDirectorResponse();

  @Input(SAVE_DIRECTOR_REQUEST)
  MessageChannel getSaveDirectorRequest();

  @Input(DELETE_DIRECTOR_REQUEST)
  MessageChannel getDeleteDirectorRequest();

  @Input(READ_DIRECTOR_REQUEST)
  MessageChannel getReadDirectorRequest();

  @Input(READ_ALL_DIRECTORS_REQUEST)
  MessageChannel getReadAllDirectorRequest();
}
