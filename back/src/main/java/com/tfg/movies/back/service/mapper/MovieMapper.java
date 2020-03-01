package com.tfg.movies.back.service.mapper;

import com.tfg.movies.back.comunication.Message;
import com.tfg.movies.back.model.dto.MovieDTO;
import com.tfg.movies.back.model.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

  @Autowired
  DirectorMapper directorMapper;
  @Autowired
  ActorMapper actorMapper;
  @Autowired
  ReviewMapper reviewMapper;
  @Autowired
  PrizeMapper prizeMapper;

  public Message toMessage(Movie movie) {
    return new Message()
      .withMovieDTO(toMovieDTO(movie));
  }

  private MovieDTO toMovieDTO(Movie movie) {
    return new MovieDTO().setTitle(movie.getTitle())
      .setData(movie.getData())
      .setDuration(movie.getDuration())
      .setCountry(movie.getCountry())
      .setGender(movie.getGender())
      .setSynopsis(movie.getSynopsis())
      .setPremiereDate(movie.getPremiereDate())
      .setScore(movie.getScore())
      .setDirectors(directorMapper.toDirectorDTO(movie.getDirectors()))
      .setActors(actorMapper.toActorDTO(movie.getActors()))
      .setPrizes(prizeMapper.toPrizeDTO(movie.getPrizes()))
      .setReviews(reviewMapper.toReviewDTO(movie.getReviews()));
  }

  public Movie toMovie(Message message) {
    return message.getMovie();
  }
}
