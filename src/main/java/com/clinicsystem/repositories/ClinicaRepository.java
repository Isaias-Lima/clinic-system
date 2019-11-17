package com.clinicsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicsystem.models.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository <Clinica, Integer>{

}
