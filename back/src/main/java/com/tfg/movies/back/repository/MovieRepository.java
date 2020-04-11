package com.tfg.movies.back.repository;

import com.tfg.movies.back.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
  List<Movie> findAll();

  Optional<Movie> findByTitle(String title);

  void deleteById(String title);
}
