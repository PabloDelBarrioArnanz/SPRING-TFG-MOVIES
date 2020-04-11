package com.tfg.movies.back.service;

import com.tfg.movies.back.comunication.director.DirectorMessage;
import com.tfg.movies.back.comunication.director.MessageDirectorSender;
import com.tfg.movies.back.repository.DirectorRepository;
import com.tfg.movies.back.service.mapper.DirectorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectorService {

  @Autowired private DirectorRepository directorRepository;
  @Autowired private DirectorMapper directorMapper;
  @Autowired private MessageDirectorSender messageDirectorSender;

  public void saveDirector(DirectorMessage directorMessage) {
    Optional.of(directorMessage)
      .map(directorMapper::toDirector)
      .map(director -> directorRepository.save(director))
      .map(directorMapper::toMessage)
      .ifPresent(messageToSend -> messageDirectorSender.sendMessageDirectorSaved(messageToSend));
  }

  public void readDirectorsByName(String name) {
    directorRepository.findByName(name)
      .parallelStream()
      .map(directorMapper::toMessage)
      .forEach(message -> messageDirectorSender.sendMessageDirectorsRead(message));
  }

  public void readAllDirectors() {
    directorRepository.findAll()
      .parallelStream()
      .map(directorMapper::toMessage)
      .forEach(message -> messageDirectorSender.sendMessageDirectorsRead(message));
  }

  public void deleteDirectorByName(String name) {
    Optional.of(name)
      .map(directorRepository::deleteByName)
      .map(id -> id >= 0)
      .ifPresent(id -> messageDirectorSender.sendMessageDirectorDeleted(id));
  }
}
