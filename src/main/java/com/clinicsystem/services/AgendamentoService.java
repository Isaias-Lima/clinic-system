package com.clinicsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Agendamento;
import com.clinicsystem.models.Medico;
import com.clinicsystem.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;

	public Page<Agendamento> buscarPaginado(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Agendamento> buscarPorMedico(Pageable pageable, Medico medico) {
		return repository.findByMedico(pageable, medico);
	}

	public List<Agendamento> buscarTodos() {
		return repository.findAll();
	}

	public Optional<Agendamento> buscarPorId(int id) {
		return repository.findById(id);
	}

	public void salvar(Agendamento agendamento) {
		repository.save(agendamento);
	}

	public void excluir(int id) {
		repository.deleteById(id);
	}

}
