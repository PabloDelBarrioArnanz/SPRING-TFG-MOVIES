package com.tfg.movies.back.service.mapper;

import com.tfg.movies.back.comunication.movie.MovieMessage;
import com.tfg.movies.back.model.dto.MovieDTO;
import com.tfg.movies.back.model.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

  @Autowired private DirectorMapper directorMapper;
  @Autowired private ActorMapper actorMapper;
  @Autowired private ReviewMapper reviewMapper;
  @Autowired private PrizeMapper prizeMapper;

  public MovieMessage toMessage(Movie movie) {
    return new MovieMessage()
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
      .setVote(movie.getVote())
      .setTotalVotes(movie.getTotalVotes())
      .setDirectors(directorMapper.toMovieDirectorDTO(movie.getDirectors()))
      .setActors(actorMapper.toMovieActorDTO(movie.getActors()))
      .setPrizes(prizeMapper.toMoviePrizeDTO(movie.getPrizes()))
      .setReviews(reviewMapper.toReviewDTO(movie.getReviews()));
  }

  public Movie toMovie(MovieMessage movieMessage) {
    return movieMessage.getMovie();
  }
}
