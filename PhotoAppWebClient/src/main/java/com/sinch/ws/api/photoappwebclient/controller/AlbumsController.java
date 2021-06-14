package com.sinch.ws.api.photoappwebclient.controller;

import com.sinch.ws.api.photoappwebclient.response.AlbumResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class AlbumsController {

  private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

  private RestTemplate restTemplate;

  private WebClient webClient;

  @Autowired
  public AlbumsController(OAuth2AuthorizedClientService oAuth2AuthorizedClientService,
      RestTemplateBuilder restTemplateBuilder,
      WebClient webClient) {
    this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    this.restTemplate = restTemplateBuilder.build();
    this.webClient = webClient;
  }

  @GetMapping("/albums")
  public String getAlbums(Model model, @AuthenticationPrincipal OidcUser principal) {

    /*
    System.out.println("Principal: " + principal);
    System.out.println("idTokenValue: " + principal.getIdToken().getTokenValue());

    // Access token
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
    OAuth2AuthorizedClient oAuth2AuthorizedClient = oAuth2AuthorizedClientService
        .loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName());
    String accessToken = oAuth2AuthorizedClient.getAccessToken().getTokenValue();
    System.out.println("Access token: " + accessToken);
    */

    String albumsUri = "http://localhost:8082/albums";
    List<AlbumResponse> albums = webClient.get().uri(albumsUri).retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<AlbumResponse>>() {
        }).block();
    /*
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + accessToken);
    HttpEntity<List<AlbumResponse>> entity = new HttpEntity(headers);

    ResponseEntity<List<AlbumResponse>> responseEntity = restTemplate
        .exchange(albumsUri, HttpMethod.GET, entity,
            new ParameterizedTypeReference<List<AlbumResponse>>() {
            });
    List<AlbumResponse> albums = responseEntity.getBody();
    */
    model.addAttribute("albums", albums);
    return "albums";
  }
}
