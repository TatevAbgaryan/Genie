package com.genie.genie.dto;

import java.io.Serializable;

public class BaseDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
