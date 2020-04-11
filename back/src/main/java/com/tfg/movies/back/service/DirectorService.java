package com.tfg.movies.back.service;

import com.tfg.movies.back.comunication.director.DirectorMessage;
import com.tfg.movies.back.comunication.director.DirectorSender;
import com.tfg.movies.back.comunication.error.ErrorMessage;
import com.tfg.movies.back.comunication.error.ErrorSender;
import com.tfg.movies.back.repository.DirectorRepository;
import com.tfg.movies.back.service.mapper.DirectorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.tfg.movies.back.service.Util.peek;

@Service
public class DirectorService {

  @Autowired private DirectorRepository directorRepository;
  @Autowired private DirectorMapper directorMapper;
  @Autowired private DirectorSender directorSender;
  @Autowired private ErrorSender errorSender;

  public void saveDirector(DirectorMessage directorMessage) {
    Optional.of(directorMessage)
      .map(directorMapper::toDirector)
      .map(director -> directorRepository.save(director))
      .map(directorMapper::toMessage)
      .map(messageToSend -> directorSender.sendMessageDirectorSaved(messageToSend))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage().withError("Impossible to save this director")));
  }

  public void readDirectorByName(String name) {
    Optional.ofNullable(name)
      .map(directorRepository::findByName)
      .map(directorMapper::toMessage)
      .map(message -> directorSender.sendMessageDirectorRead(message))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage().withError("Impossible to read this director")));
  }

  public void readAllDirectors() {
    directorRepository.findAll()
      .parallelStream()
      .map(directorMapper::toMessage)
      .forEach(message -> directorSender.sendMessageDirectorRead(message));
  }

  public void deleteDirectorByName(String name) {
    Optional.ofNullable(name)
      .map(directorRepository::findByName)
      .map(peek(directorRepository::delete))
      .map(id -> directorSender.sendMessageDirectorDeleted(Boolean.TRUE))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage().withError("Impossible to delete this director")));
  }
}
