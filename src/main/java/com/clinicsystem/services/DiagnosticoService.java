package com.clinicsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Diagnostico;
import com.clinicsystem.repositories.DiagnosticoRepository;

@Service
public class DiagnosticoService {

	@Autowired
	private DiagnosticoRepository repository;

	public List<Diagnostico> listarTodos() {
		return  repository.findAll();
	}

	public void salvar(Diagnostico diagnostico) {
		repository.save(diagnostico);
	}
	
	public void excluir(int id) {
		repository.deleteById(id);
	}
	
}

