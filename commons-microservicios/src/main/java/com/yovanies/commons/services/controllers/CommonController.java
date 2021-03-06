package com.yovanies.commons.services.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yovanies.commons.services.ICommonsService;

public class CommonController<E,S extends ICommonsService<E>> {
	
	@Autowired
	protected S entityService;

	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(entityService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<E> optEnt = entityService.findById(id);
		
		if (optEnt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(optEnt.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody E entity){
		E entityDB = entityService.save(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		entityService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
