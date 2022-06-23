package com.genie.genie.dao.dom;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.genie.genie.dao.dom.UserDom;

@Entity
@Table(name="session", schema="public")
public class SessionDom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	

	@Column(name = "auth_token")
	private String authToken;	
		
	@JoinColumn(name = "user_id")
	@OneToOne
	private UserDom user;	
	
	@Column(name = "last_login")
	private Date lastLogin;
	
	@Column(name = "client_ip")
	private String clientIp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public UserDom getUser() {
		return user;
	}

	public void setUser(UserDom user) {
		this.user = user;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
		
}
