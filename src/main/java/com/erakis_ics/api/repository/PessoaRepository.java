package com.erakis_ics.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.erakis_ics.api.entity.Pessoa;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa,Long>{
	
	@Transactional(readOnly = true)
	@Query(value = "SELECT x.pess_id, x.pess_codigo_numerico, y.end_logradouro, y.end_numero, y.end_bairro, z.tel_ddd, z.tel_numero, z.tel_tipo, q.mun_descricao, q.mun_estado_id, e.est_descricao, e.est_sigla, e.est_regiao FROM pessoa x INNER JOIN endereco y ON y.end_id=?1 INNER JOIN telefone z ON z.tel_id=?1 INNER JOIN municipio q ON q.mun_id=?1 INNER JOIN estado e ON e.est_id=?1", nativeQuery = true)
	List<Pessoa> findByPessoa(@Param(value = "pess_id")Long pess_id);
}
