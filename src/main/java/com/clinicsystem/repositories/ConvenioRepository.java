package com.clinicsystem.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicsystem.models.Convenio;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Integer> {

	Page<Convenio> findById(Pageable pageable, int id);
	Page<Convenio> findByNomeConvenioLike(Pageable pageable, String nomeConvenio);

}
