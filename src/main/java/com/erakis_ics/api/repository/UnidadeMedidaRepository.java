package com.erakis_ics.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.erakis_ics.api.entity.UnidadeMedida;

@Repository
public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Long> {
	
	@Transactional(readOnly = true)
	@Query(value = "SELECT * FROM unidade_medida u WHERE u.undmd_descricao LIKE %?1%", nativeQuery = true)
	Optional<UnidadeMedida> findByUnidadeMedida(@Param(value = "unidadeMedida") String unidadeMedida);
}
