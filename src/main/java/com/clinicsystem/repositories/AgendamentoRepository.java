package com.clinicsystem.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicsystem.models.Agendamento;
import com.clinicsystem.models.Medico;

@Repository
public interface AgendamentoRepository extends JpaRepository <Agendamento, Integer>{
	
	Page<Agendamento> findById(Pageable pageable, int id);
	Page<Agendamento> findByMedico(Pageable pageable, Medico medico);

}
