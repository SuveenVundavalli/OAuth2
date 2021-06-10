package com.sinch.ws.api.resourceserver.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
  private String userFirstName;
  private String userLastName;
  private String userId;
}
