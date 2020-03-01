package com.tfg.movies.front.repository;

import com.tfg.movies.front.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findByName(String roleName);

}
