package com.clinicsystem.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Medico;
import com.clinicsystem.models.Paciente;
import com.clinicsystem.repositories.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;

	public Page<Medico> buscarPaginado(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Medico> buscarPorMedico(Pageable pageable, Medico medico) {
		return repository.findByMedicoLike(pageable, "%" + medico + "%");
	}

	public List<Medico> buscarTodos() {
		return repository.findAll();
	}
	
	public Optional<Medico> buscarPorId(int id) {
		return repository.findById(id);
	}
	
	
	public void salvar(@Valid Medico medico) {
		repository.save(medico);
	}

	public void excluir(int id) {
		repository.deleteById(id);
	}

	public List<Medico> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object buscarPorPaciente(PageRequest of, Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
