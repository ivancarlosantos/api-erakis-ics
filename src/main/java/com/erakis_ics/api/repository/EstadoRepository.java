package com.erakis_ics.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.erakis_ics.api.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long>{
	
	@Transactional(readOnly = true)
	@Query(value = "SELECT * FROM estado u WHERE u.est_sigla=?1", nativeQuery = true)
	Optional<Estado> findBySigla(@Param(value = "sigla") String sigla);
}
