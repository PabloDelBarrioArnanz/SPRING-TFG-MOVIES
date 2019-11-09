package com.tfg.movies.back.comunication;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageStream {

  String MOVIE_SAVED = "MOVIE_SAVED";
  String MOVIE_DELETED = "MOVIE_DELETED";
  String MOVIE_READY_READ = "MOVIE_READY_READ";
  String MOVIES_READY_READ = "MOVIES_READY_READ";

  String MOVIE_TO_SAVE = "MOVIE_TO_SAVE";
  String MOVIE_TO_DELETE = "MOVIE_TO_DELETE";
  String MOVIE_TO_READ = "MOVIE_TO_READ";
  String MOVIES_TO_READ = "MOVIES_TO_READ";


  @Output(MOVIE_SAVED)
  SubscribableChannel inboundSaved();

  @Output(MOVIE_DELETED)
  SubscribableChannel inboundDeleted();

  @Output(MOVIE_READY_READ)
  SubscribableChannel inboundRead();

  @Output(MOVIES_READY_READ)
  SubscribableChannel inboundsRead();


  @Input(MOVIE_TO_SAVE)
  MessageChannel outboundToSave();

  @Input(MOVIE_TO_DELETE)
  MessageChannel outboundToDelete();

  @Input(MOVIE_TO_READ)
  MessageChannel outboundToRead();

  @Input(MOVIES_TO_READ)
  MessageChannel outboundsToRead();

}
