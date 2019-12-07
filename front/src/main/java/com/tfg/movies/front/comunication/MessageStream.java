package com.tfg.movies.front.comunication;

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


  @Input(MOVIE_SAVED)
  SubscribableChannel inboundSaved();

  @Input(MOVIE_DELETED)
  SubscribableChannel inboundDeleted();

  @Input(MOVIE_READY_READ)
  SubscribableChannel inboundRead();

  @Input(MOVIES_READY_READ)
  SubscribableChannel inboundsRead();


  @Output(MOVIE_TO_SAVE)
  MessageChannel outboundToSave();

  @Output(MOVIE_TO_DELETE)
  MessageChannel outboundToDelete();

  @Output(MOVIE_TO_READ)
  MessageChannel outboundToRead();

  @Output(MOVIES_TO_READ)
  MessageChannel outboundsToRead();

}
