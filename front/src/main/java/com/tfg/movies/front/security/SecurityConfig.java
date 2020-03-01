package com.tfg.movies.front.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  protected void configure(final HttpSecurity http) throws Exception {
    http.csrf().disable()
      .authorizeRequests()
      .anyRequest()
      .permitAll();
    //.authenticated()
    //.and()
    //.formLogin()
    //.successHandler((request, response, authentication) -> redirectStrategy.sendRedirect(request, response, "/api/movie-finder/all"));
  }

  @Bean
  public PasswordEncoder getEncoder() {
    return new BCryptPasswordEncoder();
  }

}
