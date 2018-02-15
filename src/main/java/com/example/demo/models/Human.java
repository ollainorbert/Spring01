package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;

@Entity(name = "Human")
@Table(name = "Human")
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
	@NotBlank
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Column(name = "CREATED_BY", updatable = false, nullable = false)
	@CreatedBy
	private Date CREATED_BY;

	@PrePersist
	void CREATED_BY() {
		this.CREATED_BY = new Date();
	}

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
		if (name == null) {
			this.name = "";
		} else {
			this.name = name.trim();
		}
	}

	public java.util.Date getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(java.util.Date cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	public boolean isValid() {
		if (this.getName().length() == 0) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return (this.id + " " + this.name);
	}
}
