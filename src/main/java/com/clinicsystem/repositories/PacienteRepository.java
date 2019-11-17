package com.clinicsystem.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicsystem.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Integer>{
	
	Page<Paciente> findById(Pageable pageable, int id);

	Page<Paciente> findByNomeLike(Pageable pageable, String string);

}
