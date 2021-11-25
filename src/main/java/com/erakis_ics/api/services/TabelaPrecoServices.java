package com.erakis_ics.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.TabelaPrecoDTO;
import com.erakis_ics.api.entity.TabelaPreco;
import com.erakis_ics.api.repository.TabelaPrecoRepository;

@Service
public class TabelaPrecoServices {

	@Autowired
	private TabelaPrecoRepository tabelaPrecoRepository;

	public List<TabelaPrecoDTO> findTPAll() {
		List<TabelaPrecoDTO> listAll = tabelaPrecoRepository
										.findAll()
										.stream()
										.map(tpDTO -> new TabelaPrecoDTO(tpDTO))
										.collect(Collectors.toList());
		return listAll;
	}

	public List<TabelaPreco> listTabela(Integer pageNumber, Integer pageSize) {
		Sort sort = Sort.by("titulo");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<TabelaPreco> pageResult = tabelaPrecoRepository.findAll(pageable);
		return pageResult.toList();
	}
}
