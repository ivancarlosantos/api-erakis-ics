package com.erakis_ics.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erakis_ics.api.entity.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio,Long>{
}
