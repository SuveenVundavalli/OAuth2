package com.sinch.ws.api.albumresourceserver.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class AlbumResponse {
  private String albumId;
  private String userId;
  private String albumTitle;
  private String albumDescription;
  private String albumUrl;
}
