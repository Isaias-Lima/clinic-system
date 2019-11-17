package com.clinicsystem.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicsystem.models.Especialidade;

public interface EspecialidadeRepository  extends JpaRepository <Especialidade , Integer>{

		Page<Especialidade> findById(Pageable pageable, int id);
		Page<Especialidade> findByDescricaoLike(Pageable pageable, String descricao);

}
