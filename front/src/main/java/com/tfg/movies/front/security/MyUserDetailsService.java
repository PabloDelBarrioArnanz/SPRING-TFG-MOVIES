package com.tfg.movies.front.security;

import com.tfg.movies.front.model.Role;
import com.tfg.movies.front.repository.RoleRepository;
import com.tfg.movies.front.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.core.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public UserDetails loadUserByUsername(String email) {

    return Optional.ofNullable(userRepository.findByEmail(email))
      .map(user -> new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(),
        true, true, true, getAuthorities(user.getRoles())))
      .orElseGet(() -> new org.springframework.security.core.userdetails.User(
        " ", " ", true, true, true, true,
        getAuthorities(Collections.singletonList(roleRepository.findByName("ROLE_VISITOR")))));
  }

  private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
    return roles.stream()
      .map(rol -> new SimpleGrantedAuthority(rol.getName()))
      .collect(Collectors.toList());
  }

}