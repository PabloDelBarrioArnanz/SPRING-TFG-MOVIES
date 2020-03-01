package com.tfg.movies.back.service;

import com.tfg.movies.back.comunication.Message;
import com.tfg.movies.back.comunication.MessageSender;
import com.tfg.movies.back.repository.MovieRepository;
import com.tfg.movies.back.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

@Service
public class MovieService {

  @Autowired private MovieRepository movieRepository;
  @Autowired
  private MessageSender messageSender;
  @Autowired
  private MovieMapper movieMapper;

  public void saveMovie(Message message) {
    Message messageToSend = Optional.of(message)
      .map(movieMapper::toMovie)
      .map(movie -> movieRepository.save(movie))
      .map(movieMapper::toMessage)
      .orElseThrow(RuntimeException::new);
    messageSender.sendMessageMovieSaved(messageToSend);
  }

  public void readMoviesByTitle(String title) {
    List<Message> messagesToSend = movieRepository.findByTitle(title)
      .parallelStream()
      .map(movieMapper::toMessage)
      .collect(Collectors.toList());
    messageSender.sendMessageMoviesReadByTitle(messagesToSend);
  }

  public void readAllMovies() {
    List<Message> messagesToSend = movieRepository.findAll()
      .parallelStream()
      .map(movieMapper::toMessage)
      .collect(Collectors.toList());
    messageSender.sendMessageMoviesRead(messagesToSend);
  }

  public void deleteMovieByTitle(String title) {
    Boolean result = Optional.of(movieRepository.deleteByTitle(title))
      .map(operationResult::test)
      .orElseThrow(RuntimeException::new);
    messageSender.sendMessageMovieDeleted(result);
  }

  private static IntPredicate operationResult = itemNumber -> itemNumber > 0;

}
