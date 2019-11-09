package com.tfg.movies.back.comunication;

import com.tfg.movies.back.mapper.MoviesMapper;
import com.tfg.movies.back.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageReceptor {

  @Autowired private MessageStream messageStream;
  @Autowired private MoviesMapper mapper;
  @Autowired private MovieService movieService;


  @StreamListener(MessageStream.MOVIE_TO_SAVE)
  public void movieToSave(@Payload Message message) {
    log.info("Recived a message: movie to save " + message);
    movieService.saveMovie(mapper.toMovie(message));
  }

}
