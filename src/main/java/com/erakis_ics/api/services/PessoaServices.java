package com.erakis_ics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.entity.Pessoa;
import com.erakis_ics.api.repository.PessoaRepository;

@Service
public class PessoaServices {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listPessoa(Long id){
		List<Pessoa> pessoa = pessoaRepository.findByPessoa(id);
		if (pessoa == null) {
			throw new RuntimeException("Pessoa não encontrada");
		}
		
		return pessoa;
	}
}
