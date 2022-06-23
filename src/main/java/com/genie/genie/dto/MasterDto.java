package com.genie.genie.dto;

public class MasterDto extends BaseDto{

	private static final long serialVersionUID = 1L;

	private UserDto user;
	
	private String description;
	
	private float rating;


	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto userDto) {
		this.user = userDto;
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
