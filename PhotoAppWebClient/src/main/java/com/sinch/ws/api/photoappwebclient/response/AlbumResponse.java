package com.sinch.ws.api.photoappwebclient.response;

import lombok.Data;

@Data
public class AlbumResponse {
  private String albumId;
  private String userId;
  private String albumTitle;
  private String albumDescription;
  private String albumUrl;
}
