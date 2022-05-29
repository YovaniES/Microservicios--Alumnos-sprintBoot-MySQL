package com.yovanies.commons.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yovanies.commons.app.entity.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Long> {

}
