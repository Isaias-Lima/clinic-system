package com.clinicsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Convenio;
import com.clinicsystem.repositories.ConvenioRepository;

@Service
public class ConvenioService {

	@Autowired
	private ConvenioRepository repository;

	public Page<Convenio> buscarPaginado(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Convenio> buscarPorConvenio(Pageable pageable, String convenio) {
		return repository.findByNomeConvenioLike(pageable, "%" + convenio + "%");
	}

	public List<Convenio> buscarTodos() {
		return repository.findAll();
	}
	
	public Optional<Convenio> buscarPorId(int id) {
		return repository.findById(id);
	}
	
	
	public void salvar(Convenio convenio) {
		repository.save(convenio);
	}

	public void excluir(int id) {
		repository.deleteById(id);
	}
	
}
