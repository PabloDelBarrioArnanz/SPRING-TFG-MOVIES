package com.tfg.movies.front.repository;

import com.tfg.movies.front.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}
