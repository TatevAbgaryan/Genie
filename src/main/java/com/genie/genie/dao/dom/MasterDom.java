package com.genie.genie.dao.dom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="master", schema="public")
public class MasterDom {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@ManyToOne()
    @JoinColumn(name = "user_id")
	private UserDom user;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "rating")
	private float rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDom getUser() {
		return user;
	}

	public void setUser(UserDom user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
}
