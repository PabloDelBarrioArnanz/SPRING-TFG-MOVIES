package com.tfg.movies.front.comunication.movie;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MovieStream {

  String SAVE_MOVIE_RESPONSE = "SAVE_MOVIE_RESPONSE";
  String DELETE_MOVIE_RESPONSE = "DELETE_MOVIE_RESPONSE";
  String READ_MOVIE_RESPONSE = "READ_MOVIE_RESPONSE";
  String VOTE_MOVIE_RESPONSE = "VOTE_MOVIE_RESPONSE";

  String SAVE_MOVIE_REQUEST = "SAVE_MOVIE_REQUEST";
  String DELETE_MOVIE_REQUEST = "DELETE_MOVIE_REQUEST";
  String READ_MOVIE_REQUEST = "READ_MOVIE_REQUEST";
  String READ_ALL_MOVIES_REQUEST = "READ_ALL_MOVIES_REQUEST";
  String VOTE_MOVIE_REQUEST = "VOTE_MOVIE_REQUEST";


  @Input(SAVE_MOVIE_RESPONSE)
  SubscribableChannel getResponseFromSavedMovie();

  @Input(DELETE_MOVIE_RESPONSE)
  SubscribableChannel getResponseFromDeletedMovie();

  @Input(READ_MOVIE_RESPONSE)
  SubscribableChannel getResponseFromReadMovie();

  @Input(VOTE_MOVIE_RESPONSE)
  SubscribableChannel getResponseFromVotedMovie();


  @Output(SAVE_MOVIE_REQUEST)
  MessageChannel sendRequestToSaveMovie();

  @Output(DELETE_MOVIE_REQUEST)
  MessageChannel sendRequestToDeleteMovie();

  @Output(READ_MOVIE_REQUEST)
  MessageChannel sendRequestToReadMovie();

  @Output(READ_ALL_MOVIES_REQUEST)
  MessageChannel sendRequestToSaveAllMovies();

  @Output(VOTE_MOVIE_REQUEST)
  MessageChannel sendRequestToVoteMovie();
}
