package com.tfg.movies.back.comunication.movie;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MovieStream {

  String SAVE_MOVIE_RESPONSE = "SAVE_MOVIE_RESPONSE";
  String DELETE_MOVIE_RESPONSE = "DELETE_MOVIE_RESPONSE";
  String READ_MOVIE_RESPONSE = "READ_MOVIE_RESPONSE";

  String SAVE_MOVIE_REQUEST = "SAVE_MOVIE_REQUEST";
  String DELETE_MOVIE_REQUEST = "DELETE_MOVIE_REQUEST";
  String READ_MOVIE_REQUEST = "READ_MOVIE_REQUEST";
  String READ_ALL_MOVIES_REQUEST = "READ_ALL_MOVIES_REQUEST";


  @Output(SAVE_MOVIE_RESPONSE)
  SubscribableChannel sendSaveMovieResponse();

  @Output(DELETE_MOVIE_RESPONSE)
  SubscribableChannel sendDeleteMovieResponse();

  @Output(READ_MOVIE_RESPONSE)
  SubscribableChannel sendReadMovieResponse();

  @Input(SAVE_MOVIE_REQUEST)
  MessageChannel getSaveMovieRequest();

  @Input(DELETE_MOVIE_REQUEST)
  MessageChannel getDeleteMovieRequest();

  @Input(READ_MOVIE_REQUEST)
  MessageChannel getReadMovieRequest();

  @Input(READ_ALL_MOVIES_REQUEST)
  MessageChannel getReadAllMoviesRequest();

}
