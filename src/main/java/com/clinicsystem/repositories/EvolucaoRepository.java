package com.clinicsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicsystem.models.Evolucao;

@Repository
public interface EvolucaoRepository extends JpaRepository<Evolucao, Integer> {

}
