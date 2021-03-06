package com.erakis_ics.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.erakis_ics.api.entity.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Long>{
	
	@Transactional(readOnly = true)
	@Query(value = "",nativeQuery = true)
	List<Telefone> findByNumero(String numero);
}
