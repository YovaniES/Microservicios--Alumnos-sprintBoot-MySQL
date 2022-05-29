package com.yovanies.app.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yovanies.app.entity.Alumno;
import com.yovanies.app.services.AlumnoServiceImpl;
import com.yovanies.commons.services.controllers.CommonController;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoServiceImpl> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Alumno alumno,@PathVariable Long id ){
		Optional<Alumno> optAlum = entityService.findById(id);
		
		if (optAlum.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Alumno alumnoDB = optAlum.get();
		
		alumnoDB.setNombre(alumno.getNombre());
		alumnoDB.setApellido(alumno.getApellido());
		alumnoDB.setEmail(alumno.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entityService.save(alumnoDB));
	}

}
