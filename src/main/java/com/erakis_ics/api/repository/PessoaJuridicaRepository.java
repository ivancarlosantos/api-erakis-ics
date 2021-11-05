package com.erakis_ics.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erakis_ics.api.dtos.PessoaJuridicaDTO;
import com.erakis_ics.api.entity.PessoaJuridica;

/*  
 * @author by: icarlos 
 */

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

	Optional<PessoaJuridicaDTO> findByCnpj(String cnpj);

	Optional<PessoaJuridicaDTO> findByRazaoSocial(@Param(value = "razaoSocial") String razaoSocial);

	Optional<PessoaJuridicaDTO> findByNomeFantasia(@Param(value = "nomeFantasia") String nomeFantasia);
}
