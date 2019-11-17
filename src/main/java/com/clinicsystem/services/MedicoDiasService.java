package com.clinicsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.MedicoDias;
import com.clinicsystem.repositories.MedicoDiasRepository;

@Service
public class MedicoDiasService {

	@Autowired
	private MedicoDiasRepository repository;
	
	public List<MedicoDias> listarTodos() {
		return  repository.findAll();
	}

	public void salvar(MedicoDias medicoDias) {
		repository.save(medicoDias);
	}
	
	public void excluir(int id) {
		repository.deleteById(id);
	}
	
}
