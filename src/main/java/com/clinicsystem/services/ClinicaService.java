package com.clinicsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Clinica;
import com.clinicsystem.repositories.ClinicaRepository;

@Service
public class ClinicaService {

	@Autowired
	private ClinicaRepository repository;
	
	public List<Clinica> listarTodos() {
		return  repository.findAll();
	}

	public void salvar(Clinica clinica) {
		repository.save(clinica);
	}
	
	public void excluir(int id) {
		repository.deleteById(id);
	}
	
}
