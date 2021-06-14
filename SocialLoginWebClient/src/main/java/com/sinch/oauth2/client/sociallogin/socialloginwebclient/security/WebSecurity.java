package com.sinch.oauth2.client.sociallogin.socialloginwebclient.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

  @Autowired
  ClientRegistrationRepository clientRegistrationRepository;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .oauth2Login()
        .and()
        .logout()
        .logoutSuccessHandler(oidcLogoutSuccessHandler())
        .invalidateHttpSession(true) // default spring boot behaviour
        .clearAuthentication(true) // default spring boot behaviour
        .deleteCookies("JSESSIONID");
  }

  private OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
    OidcClientInitiatedLogoutSuccessHandler successHandler = new OidcClientInitiatedLogoutSuccessHandler(
        clientRegistrationRepository);
    successHandler.setPostLogoutRedirectUri("http://localhost:8080");
    return successHandler;
  }
}
