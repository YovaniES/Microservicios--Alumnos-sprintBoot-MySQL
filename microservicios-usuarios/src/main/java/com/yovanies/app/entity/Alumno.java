package com.yovanies.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellido;

	@Column(unique = true)
	private String email;

	@Column(name = "crate_at")
	private Date createAt;

	// Persistimos la fecha - create new date.
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}


}
