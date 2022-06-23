package com.genie.genie.dao.dom;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="\"user\"", schema="public")
public class UserDom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	

	@Column(name = "username")
	private String username;	

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	
	@Column(name = "last_login")
	private Date lastLogin;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	
}
