package com.yovanies.app.services;

import org.springframework.stereotype.Service;

import com.yovanies.app.entity.Alumno;
import com.yovanies.app.repository.IAlumnoRepository;
import com.yovanies.commons.services.CommonsServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonsServiceImpl<Alumno, IAlumnoRepository> implements IAlumnoService {

}
