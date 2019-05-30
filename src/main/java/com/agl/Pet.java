package com.agl;

import com.google.gson.annotations.Expose;

public class Pet {
	
	@Expose
	private String name;
	
	@Expose
	private String type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
