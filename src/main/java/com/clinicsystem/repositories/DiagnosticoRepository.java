package com.clinicsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicsystem.models.Diagnostico;

@Repository
public interface DiagnosticoRepository extends JpaRepository <Diagnostico, Integer> {

}
