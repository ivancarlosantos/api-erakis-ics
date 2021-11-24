package com.erakis_ics.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.EnderecoDTO;
import com.erakis_ics.api.entity.Endereco;
import com.erakis_ics.api.repository.EnderecoRepository;

@Service
public class EnderecoServices {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco saveEndereco(Endereco end) {
		Endereco e = enderecoRepository.save(end);
		return e;
	}
	
	public List<EnderecoDTO> listEndereco(){
		List<EnderecoDTO> listAll = enderecoRepository
									.findAll()
									.stream()
									.map(end->new EnderecoDTO(end))
									.collect(Collectors.toList());
		return listAll;
	}
	
	public List<Endereco> listEndereco(Integer numberPage, Integer pageSize){
		List<Endereco> pageResult = enderecoRepository.findAll(Sort.by("logradouro")).subList(numberPage, 10);
		return pageResult;
	}
}
