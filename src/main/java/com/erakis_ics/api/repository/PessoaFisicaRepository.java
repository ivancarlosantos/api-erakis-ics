package com.erakis_ics.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.erakis_ics.api.entity.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>{

	
	@Transactional(readOnly = true)
	@Query(value = "SELECT * FROM pessoa_fisica u WHERE u.psfis_nome LIKE %?1% ORDER BY u.psfis_cpf", nativeQuery = true)
	Optional<PessoaFisica> findByNome(@Param(value = "nome") String nome);

	@Transactional(readOnly = true)
	@Query(value = "SELECT * FROM pessoa_fisica u WHERE u.psfis_cpf=?1", nativeQuery = true)
	Optional<PessoaFisica> findByCpf(@Param(value = "cpf") String cpf);
 
}
