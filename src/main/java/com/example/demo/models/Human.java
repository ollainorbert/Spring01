package com.example.demo.models;

public class Human {
	public Human(String name) {
		this.setName(name);
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
