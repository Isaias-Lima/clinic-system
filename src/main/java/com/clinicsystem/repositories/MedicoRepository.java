package com.clinicsystem.repositories;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicsystem.models.Medico;
import com.clinicsystem.models.Paciente;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	
	Page<Medico> findById(Pageable pageable, int id);
	
	Page<Medico> findByMedicoLike(Pageable pageable, String Medico);
	
	void save(@Valid Paciente paciente);
}
