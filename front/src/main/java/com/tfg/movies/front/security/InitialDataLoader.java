package com.tfg.movies.front.security;

import com.tfg.movies.front.model.Role;
import com.tfg.movies.front.model.User;
import com.tfg.movies.front.repository.RoleRepository;
import com.tfg.movies.front.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

  private boolean alreadySetup = false;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public void onApplicationEvent(ContextRefreshedEvent event) {

    if (alreadySetup)
      return;

    Optional.ofNullable(userRepository.findByEmail("admin@admin.com"))
      .orElseGet(() -> {
        createRoleIfNotFound("ROLE_ADMIN");
        createRoleIfNotFound("ROLE_VISITOR");
        createAdminDefault();
        createVisitorDefault();
        return null;
      });

    alreadySetup = true;
  }

  @Transactional
  public Role createRoleIfNotFound(String name) {
    return Optional.ofNullable(roleRepository.findByName(name))
      .orElseGet(() -> roleRepository.save(new Role(name)));
  }

  private void createVisitorDefault() {
    Role visitorRole = roleRepository.findByName("ROLE_VISITOR");
    User userVisitor = User.builder()
      .email("visitor@visitor.com")
      .firstName("visitor_name")
      .lastName("visitor_lastName")
      .password(passwordEncoder.encode("visitor"))
      .roles(Collections.singletonList(visitorRole))
      .enabled(true)
      .build();
    userRepository.save(userVisitor);
  }

  private void createAdminDefault() {
    Role adminRole = roleRepository.findByName("ROLE_ADMIN");
    User userAdmin = User.builder()
      .email("admin@admin.com")
      .firstName("admin_name")
      .lastName("admin_lastName")
      .password(passwordEncoder.encode("admin"))
      .roles(Collections.singletonList(adminRole))
      .enabled(true)
      .build();
    userRepository.save(userAdmin);
  }

}