package com.agl;

import java.util.List;

import com.google.gson.annotations.Expose;

public class Person {
	@Expose
	private String name;
	
	@Expose
	private String gender;
	
	@Expose
	private int age;
	
	@Expose
	private List<Pet> pets;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Pet> getPetsList() {
		return pets;
	}
	public void setPetsList(List<Pet> petsList) {
		this.pets = petsList;
	}
	
	
	
	

}
