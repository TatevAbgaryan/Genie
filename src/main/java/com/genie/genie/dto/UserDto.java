package com.genie.genie.dto;


import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genie.genie.dao.dom.UserDom;
import com.genie.genie.dto.BaseDto;

public class UserDto extends BaseDto {

	private static final long serialVersionUID = 1L;

    @NotBlank(message = "Username may not be null or empty")
	private String username;	
	
    @NotBlank(message = "Password may not be null or empty")
	private String password;

	private String email;
	
	private Date createdOn;	
	
	private Date lastLogin;

	@JsonIgnore
	private UserDom userDom;

	public UserDto() {}
	
	public UserDto(UserDom userDom) {
		this.setId(userDom.getId());
		this.username = userDom.getUsername();
		this.email = userDom.getEmail();
		this.createdOn = userDom.getCreatedOn();
		this.lastLogin = userDom.getLastLogin();
		this.userDom = userDom;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;	
	}

	public UserDom getUserDom() {
		return userDom;
	}

	public void setUserDom(UserDom userDom) {
		this.userDom = userDom;
	}
}
