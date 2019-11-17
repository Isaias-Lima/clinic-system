package com.clinicsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Endereco;
import com.clinicsystem.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
		
	public List<Endereco> listarTodos() {
		return  repository.findAll();
	}

	public void salvar(Endereco endereco) {
		repository.save(endereco);
	}
	
	public void excluir(int id) {
		repository.deleteById(id);
	}

}
