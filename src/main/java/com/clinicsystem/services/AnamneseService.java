package com.clinicsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Anamnese;
import com.clinicsystem.repositories.AnamneseRepository;

@Service
public class AnamneseService {

	@Autowired
	private AnamneseRepository repository;
	
	public List<Anamnese> listarTodos() {
		return  repository.findAll();
	}

	public void salvar(Anamnese anamnese) {
		repository.save(anamnese);
	}
	
	public void excluir(int id) {
		repository.deleteById(id);
	}

	public Object buscarPaginado(PageRequest of) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
