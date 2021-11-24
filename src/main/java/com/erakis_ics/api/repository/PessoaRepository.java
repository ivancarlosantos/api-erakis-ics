package com.erakis_ics.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.erakis_ics.api.entity.Pessoa;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa,Long>{
}
