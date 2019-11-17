package com.clinicsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicsystem.models.Cid;

@Repository
public interface CidRepository extends JpaRepository<Cid, Integer> {

}
