package com.clinicsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Cid;
import com.clinicsystem.repositories.CidRepository;

@Service
public class CidService {

	@Autowired
	private CidRepository repository;

	public List<Cid> listarTodos() {
		return  repository.findAll();
	}

	public void salvar(Cid cid) {
		repository.save(cid);
	}
	
	public void excluir(int id) {
		repository.deleteById(id);
	}

}
