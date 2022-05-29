package com.yovanies.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yovanies.app.entity.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {

}
