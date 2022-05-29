package com.yovanies.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonsServiceImpl<E,eR extends JpaRepository<E, Long>> implements ICommonsService<E> {

	@Autowired
	protected eR entityRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {		
		return entityRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id) {		
		return entityRepository.findById(id);
	}

	@Override
	@Transactional
	public E save(E entity) {	
		return entityRepository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		entityRepository.deleteById(id);		
	}

}
