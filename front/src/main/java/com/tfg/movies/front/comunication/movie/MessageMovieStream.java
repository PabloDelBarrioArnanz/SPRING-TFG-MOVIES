package com.tfg.movies.front.comunication.movie;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageMovieStream {

  String MOVIE_SAVED = "MOVIE_SAVED";
  String MOVIE_DELETED = "MOVIE_DELETED";
  String MOVIE_READY_READ = "MOVIE_READY_READ";

  String MOVIE_TO_SAVE = "MOVIE_TO_SAVE";
  String MOVIE_TO_DELETE = "MOVIE_TO_DELETE";
  String MOVIE_TO_READ = "MOVIE_TO_READ";
  String MOVIES_TO_READ = "MOVIES_TO_READ";


  @Input(MOVIE_SAVED)
  SubscribableChannel getResponseFromSavedMovie();

  @Input(MOVIE_DELETED)
  SubscribableChannel getResponseFromDeletedMovie();

  @Input(MOVIE_READY_READ)
  SubscribableChannel getResponseFromReadMovie();

  @Output(MOVIE_TO_SAVE)
  MessageChannel sendRequestToSaveMovie();

  @Output(MOVIE_TO_DELETE)
  MessageChannel sendRequestToDeleteMovie();

  @Output(MOVIE_TO_READ)
  MessageChannel sendRequestToReadMovie();

  @Output(MOVIES_TO_READ)
  MessageChannel sendRequestToSaveAllMovies();

}
