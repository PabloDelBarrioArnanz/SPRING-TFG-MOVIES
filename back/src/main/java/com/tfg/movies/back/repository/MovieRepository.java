package com.tfg.movies.back.repository;

import com.tfg.movies.back.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

  List<Movie> findByTitle(String title);

  boolean deleteByTitle(String title);

}
