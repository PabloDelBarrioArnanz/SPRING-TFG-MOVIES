package com.tfg.movies.back.service.mapper;

import com.tfg.movies.back.comunication.director.DirectorMessage;
import com.tfg.movies.back.model.dto.DirectorDTO;
import com.tfg.movies.back.model.entity.Director;
import com.tfg.movies.back.model.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DirectorMapper {

  public DirectorMessage toMessage(Director director) {
    return new DirectorMessage()
      .withDirectorDTO(toDirectorDTO(director));
  }

  public DirectorDTO toDirectorDTO(Director director) {
    return new DirectorDTO()
      .setAge(director.getAge())
      .setName(director.getName())
      .setMovies(director.getMovies().stream()
        .map(Movie::getTitle)
        .collect(Collectors.toSet()));
  }

  public DirectorDTO toMovieDirectorDTO(Director director) {
    return new DirectorDTO()
      .setAge(director.getAge())
      .setName(director.getName());
  }

  public Director toDirector(DirectorMessage directorMessage) {
    return directorMessage.getDirector();
  }

  public Set<DirectorDTO> toMovieDirectorDTO(Set<Director> directors) {
    return directors.stream()
      .map(this::toMovieDirectorDTO)
      .collect(Collectors.toSet());
  }
}
