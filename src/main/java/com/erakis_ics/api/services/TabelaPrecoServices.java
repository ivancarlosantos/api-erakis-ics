package com.erakis_ics.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.TabelaPrecoDTO;
import com.erakis_ics.api.repository.TabelaPrecoRepository;

@Service
public class TabelaPrecoServices {

	@Autowired
	private TabelaPrecoRepository tabelaPrecoRepository;
	
	public List<TabelaPrecoDTO> findTPAll(){
		List<TabelaPrecoDTO> listAll =  tabelaPrecoRepository
									   .findAll()
									   .stream()
									   .map(tpDTO->new TabelaPrecoDTO(tpDTO))
									   .collect(Collectors.toList());
		return listAll;
	}
}
