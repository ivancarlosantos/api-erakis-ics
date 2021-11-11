package com.erakis_ics.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.VariacaoProdutoDTO;
import com.erakis_ics.api.repository.VariacaoProdutoRepository;

@Service
public class VariacaoProdutoServices {

	@Autowired
	private VariacaoProdutoRepository variacaoProdutoRepository;
	
	
	
	
		
	public List<VariacaoProdutoDTO> findVPAll(){
		List<VariacaoProdutoDTO> listAll = variacaoProdutoRepository
										   .findAll()
										   .stream()
										   .map(vpDTO->new VariacaoProdutoDTO(vpDTO))
										   .collect(Collectors.toList());
		return listAll;
	}
}
