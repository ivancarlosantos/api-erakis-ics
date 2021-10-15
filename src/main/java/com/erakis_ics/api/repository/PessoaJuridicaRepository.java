package com.erakis_ics.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.erakis_ics.api.entity.PessoaJuridica;

/*  
 * @author by: icarlos 
 */

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

	List<PessoaJuridica> findByCnpj(String cnpj);

	@Transactional(readOnly = true)
	@Query(value = "SELECT * FROM pessoa_juridica u WHERE u.psjur_razao_social LIKE %?1% ", nativeQuery = true)
	Optional<PessoaJuridica> findByRazaoSocial(@Param(value = "razaoSocial") String razaoSocial);

	@Transactional(readOnly = true)
	@Query(value = "SELECT * FROM pessoa_juridica p WHERE p.psjur_nome_fantasia LIKE %?1%", nativeQuery = true)
	Optional<PessoaJuridica> findByNomeFantasia(@Param(value = "nomeFantasia") String nomeFantasia);
}
