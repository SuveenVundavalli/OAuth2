package com.sinch.ws.api.resourceserver.controller;

import com.sinch.ws.api.resourceserver.response.UserResponse;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @GetMapping("/status/check")
  public String status() {
    return "Working...";
  }

//  @Secured("ROLE_developer")
//  @PreAuthorize("hasAuthority('ROLE_developer')")
  @PreAuthorize("hasRole('developer') or #id == #jwt.subject")
  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
    return "Deleted user with id: " + id + " and JWT subject " + jwt.getSubject();
  }

  @GetMapping("/{id}")
  @PostAuthorize("returnObject.userId == #jwt.subject")
  public UserResponse getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
    return new UserResponse("Suveen", "Vundavalli", id);
  }
}
