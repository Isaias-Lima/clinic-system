package com.clinicsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Evolucao;
import com.clinicsystem.repositories.EvolucaoRepository;

@Service
public class EvolucaoService {
	
	@Autowired
	private EvolucaoRepository repository;
	
	public List<Evolucao> listarTodos() {
		return  repository.findAll();
	}

	public void salvar(Evolucao evolucao) {
		repository.save(evolucao);
	}
	
	public void excluir(int id) {
		repository.deleteById(id);
	}
}
