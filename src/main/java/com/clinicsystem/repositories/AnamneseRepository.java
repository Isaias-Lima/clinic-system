package com.clinicsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicsystem.models.Anamnese;

@Repository
public interface AnamneseRepository extends JpaRepository<Anamnese , Integer> {

}
