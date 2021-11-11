package com.erakis_ics.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erakis_ics.api.entity.PrecoComercializavel;

@Repository
public interface PrecoComercializavelRepository extends JpaRepository<PrecoComercializavel, Long>{
}
