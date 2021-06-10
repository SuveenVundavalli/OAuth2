package com.sinch.ws.api.photoresourceserver.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class PhotoResponse {
  private String albumId;
  private String photoId;
  private String userId;
  private String photoTitle;
  private String photoDescription;
  private String photoUrl;
}
