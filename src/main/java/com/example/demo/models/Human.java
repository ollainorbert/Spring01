package com.example.demo.models;

public class Human {
	public Human(String name) {
		this.setName(name);
	}
	
	private long id;
	private String name;

	public long getId() {
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
