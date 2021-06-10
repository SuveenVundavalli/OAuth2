package com.sinch.ws.api.photoresourceserver.controller;

import com.sinch.ws.api.photoresourceserver.response.PhotoResponse;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotoController {

  @GetMapping
  public List<PhotoResponse> getPhotos() {
    PhotoResponse photo1 =
        PhotoResponse.builder()
            .albumId("albumIdHere")
            .photoId("1")
            .userId("1")
            .photoTitle("Photo 1 title")
            .photoDescription("Photo 1 description")
            .photoUrl("Photo 1 URL")
            .build();
    PhotoResponse photo2 =
        PhotoResponse.builder()
            .albumId("albumIdHere")
            .photoId("2")
            .userId("1")
            .photoTitle("Photo 2 title")
            .photoDescription("Photo 2 description")
            .photoUrl("Photo 2 URL")
            .build();

    return Arrays.asList(photo1, photo2);
  }
}
