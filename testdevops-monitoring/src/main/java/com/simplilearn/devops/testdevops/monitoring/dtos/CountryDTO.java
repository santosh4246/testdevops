package com.simplilearn.devops.testdevops.monitoring.dtos;

import java.io.Serializable;

import lombok.NonNull;

public class CountryDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	@NonNull
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
