package com.clinicsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicsystem.models.MedicoDias;

@Repository
public interface MedicoDiasRepository extends JpaRepository <MedicoDias, Integer>{

}
