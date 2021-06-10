package com.sinch.ws.api.albumresourceserver.controller;

import com.sinch.ws.api.albumresourceserver.response.AlbumResponse;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumController {

  @GetMapping
  public List<AlbumResponse> getAlbums() {
    AlbumResponse album1 =
        AlbumResponse.builder()
            .albumId("albumIdHere")
            .userId("1")
            .albumTitle("Album 1 title")
            .albumDescription("Album 1 description")
            .albumUrl("Album 1 URL")
            .build();
    AlbumResponse album2 =
        AlbumResponse.builder()
            .albumId("albumIdHere")
            .userId("2")
            .albumTitle("Album 2 title")
            .albumDescription("Album 2 description")
            .albumUrl("Album 2 URL")
            .build();
    return Arrays.asList(album1, album2);
  }
}
