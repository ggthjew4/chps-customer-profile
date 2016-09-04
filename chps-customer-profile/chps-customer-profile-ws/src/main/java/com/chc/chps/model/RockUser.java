package com.chc.chps.model;

import java.io.Serializable;

public class RockUser implements Serializable{
	
	private static final long serialVersionUID = 5012879377737269025L;

	private int id;
	
	private String username;
	
	private String password;
	
	public RockUser(){}

	public RockUser(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}


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
	

}
