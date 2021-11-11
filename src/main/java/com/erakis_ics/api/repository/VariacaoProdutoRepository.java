package com.erakis_ics.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erakis_ics.api.entity.VariacaoProduto;

@Repository
public interface VariacaoProdutoRepository extends JpaRepository<VariacaoProduto,Long>{
}
