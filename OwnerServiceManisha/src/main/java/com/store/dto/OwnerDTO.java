package com.store.dto;

import java.util.List;

public class OwnerDTO {
	
	 private long ownerid;
	 
	 private String ownername;
	 
	 private String owneremail;
	 
	 private String username;
	 
	 private String email;

	 
	 public long getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(long ownerid) {
		this.ownerid = ownerid;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getOwneremail() {
		return owneremail;
	}

	public void setOwneremail(String owneremail) {
		this.owneremail = owneremail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

