package com.store.payload.response;
import java.util.List;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long ownerid;
  private String ownername;
  private String owneremail;
  private List<String> roles;

  public JwtResponse(String accessToken, Long ownerid, String ownername, String owneremail, List<String> roles) {
    this.token = accessToken;
    this.ownerid = ownerid;
    this.ownername = ownername;
    this.owneremail = owneremail;
    this.roles = roles;
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Long getId() {
    return ownerid;
  }

  public void setId(Long ownerid) {
    this.ownerid = ownerid;
  }

  public String getEmail() {
    return owneremail;
  }

  public void setEmail(String owneremail) {
    this.owneremail = owneremail;
  }

  public String getUsername() {
    return ownername;
  }

  public void setUsername(String ownername) {
    this.ownername = ownername;
  }

  public List<String> getRoles() {
    return roles;
  }
}
