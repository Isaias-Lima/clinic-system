package com.clinicsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Especialidade;
import com.clinicsystem.repositories.EspecialidadeRepository;

@Service
public class EspecialidadeService {
	
	@Autowired
	private EspecialidadeRepository repository;

	public Page<Especialidade> buscarPaginado(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Especialidade> buscarPorEspecialidade(Pageable pageable, String especialidade) {
		return repository.findByDescricaoLike(pageable, "%" + especialidade + "%");
	}

	public List<Especialidade> buscarTodos() {
		return repository.findAll();
	}
	
	public Optional<Especialidade> buscarPorId(int id) {
		return repository.findById(id);
	}
	
	
	public void salvar(Especialidade especialidade) {
		repository.save(especialidade);
	}

	public void excluir(int id) {
		repository.deleteById(id);
	}

}
