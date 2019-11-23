package com.tfg.movies.back.comunication;

import com.tfg.movies.back.mapper.MovieMapper;
import com.tfg.movies.back.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageReceptor {

  @Autowired private MessageStream messageStream;
  @Autowired private MovieMapper mapper;
  @Autowired private MovieService movieService;


  @StreamListener(MessageStream.MOVIE_TO_SAVE)
  public void movieToSave(@Payload Message message) {
    log.info("Received a message: movie to save " + message);
    movieService.saveMovie(mapper.toMovie(message));
  }

  @StreamListener(MessageStream.MOVIE_TO_READ)
  public void movieToRead(@Payload String title) {
    log.info("Received a message: movie to read " + title);
    movieService.readMoviesByTitle(title);
  }

  @StreamListener(MessageStream.MOVIES_TO_READ)
  public void moviesToRead() {
    log.info("Received a message: read all movies");
    movieService.readAllMovies();
  }

  @StreamListener(MessageStream.MOVIE_DELETED)
  public void movieToDelete(@Payload String title) {
    log.info("Received a message: movie to read " + title);
    movieService.deleteMovieByTitle(title);
  }

}
