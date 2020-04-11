package com.tfg.movies.back.repository;

import com.tfg.movies.back.model.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, String> {
  List<Director> findAll();
  Director findByName(String name);
  void delete(Director director);
}
