package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Human")
@Table(name = "human")
public class Human implements Serializable{
	private static final long serialVersionUID = -7740609680249087877L;

	public Human() {
	}
	
	public Human(String name) {
		this.setName(name);
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Column
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
	
	@Override
	public String toString() {
		return (this.id + " " + this.name);
	}
}
