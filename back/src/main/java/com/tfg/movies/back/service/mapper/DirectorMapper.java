package com.tfg.movies.back.service.mapper;

import com.tfg.movies.back.comunication.director.DirectorMessage;
import com.tfg.movies.back.model.dto.DirectorDTO;
import com.tfg.movies.back.model.entity.Director;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DirectorMapper {

  public DirectorMessage toMessage(Director director) {
    return new DirectorMessage()
      .withDirectorDTO(toDirectorDTO(director));
  }
  
  public Set<DirectorDTO> toDirectorDTO(Set<Director> directors) {
    return directors.stream()
      .map(this::toDirectorDTO)
      .collect(Collectors.toSet());
  }

  public DirectorDTO toDirectorDTO(Director director) {
    return new DirectorDTO()
      .setAge(director.getAge())
      .setName(director.getName());
  }

  public Director toDirector(DirectorMessage directorMessage) {
    return directorMessage.getDirector();
  }
}
