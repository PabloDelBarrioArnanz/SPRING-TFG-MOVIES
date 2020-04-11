package com.tfg.movies.front.service;

import com.tfg.movies.front.comunication.director.MessageDirectorSender;
import com.tfg.movies.front.model.entity.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

@Service
public class DirectorService {

  @Autowired private MessageDirectorSender messageDirectorSender;

  public void createDirector(Director director) {
    messageDirectorSender.sendMessageDirectorToSave(director);
  }

  public void getDirector(@NotEmpty String title) {
    messageDirectorSender.sendMessageDirectorToRead(title);
  }

  public void getDirectors() {
    messageDirectorSender.sendMessageDirectorsToRead();
  }

  public void deleteDirector(@NotEmpty String name) {
    messageDirectorSender.sendMessageDirectorsToDelete(name);
  }

}
