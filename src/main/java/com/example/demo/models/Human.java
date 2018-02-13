package com.example.demo.models;

import java.io.Serializable;
//import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Human")
@Table(name = "Human")
//@NamedQueries({
//	@NamedQuery(name = "Human.findByName", query = "SELECT r FROM Human WHERE r.name = :name")
//})
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
	@Column(name = "name")
	private String name;

	//private UUID id2;
	
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
