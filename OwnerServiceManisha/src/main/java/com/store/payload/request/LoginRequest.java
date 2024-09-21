package com.store.payload.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
  private String ownername;

	@NotBlank
	private String ownerpassword;

	public String getUsername() {
		return ownername;
	}

	public void setUsername(String ownername) {
		this.ownername = ownername;
	}

	public String getPassword() {
		return ownerpassword;
	}

	public void setPassword(String ownerpassword) {
		this.ownerpassword = ownerpassword;
	}
}
