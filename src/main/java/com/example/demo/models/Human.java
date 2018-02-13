package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;

@Entity(name = "Human")
@Table(name = "Human")
// @NamedQueries({
// @NamedQuery(name = "Human.findByName", query = "SELECT r FROM Human WHERE
// r.name = :name")
// })
public class Human implements Serializable {
	private static final long serialVersionUID = -7740609680249087877L;

	public Human() {
	}

	public Human(String name) {
		this.setName(name);
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "CREATED_BY")
	@CreatedBy
	private java.util.Date CREATED_BY;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.Date getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(java.util.Date cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	@Override
	public String toString() {
		return (this.id + " " + this.name);
	}
}
