package com.tfg.movies.front.service;

import com.tfg.movies.front.comunication.director.DirectorSender;
import com.tfg.movies.front.model.entity.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

@Service
public class DirectorService {

  @Autowired private DirectorSender directorSender;

  public void createDirector(Director director) {
    directorSender.sendMessageDirectorToSave(director);
  }

  public void getDirector(@NotEmpty String title) {
    directorSender.sendMessageDirectorToRead(title);
  }

  public void getDirectors() {
    directorSender.sendMessageDirectorsToRead();
  }

  public void deleteDirector(@NotEmpty String name) {
    directorSender.sendMessageDirectorsToDelete(name);
  }

}
