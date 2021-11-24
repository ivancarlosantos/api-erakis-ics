package com.erakis_ics.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.TelefoneDTO;
import com.erakis_ics.api.entity.Telefone;
import com.erakis_ics.api.repository.TelefoneRepository;

@Service
public class TelefoneServices {

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	public Telefone saveTelefone(Telefone tel) {
		return telefoneRepository.save(tel);
	}
	
	public List<TelefoneDTO> listTelefonesAll(){
		List<TelefoneDTO> listAll = telefoneRepository
									.findAll()
									.stream()
									.map(tel->new TelefoneDTO(tel))
									.collect(Collectors.toList());
		return listAll;
	}
	
	public List<Telefone> listTelefones(Integer numberPage, Integer numberSize){
		Sort sort = Sort.by("numero");
		Pageable pageable = PageRequest.of(numberPage, numberSize, sort);
		Page<Telefone> pageResult = telefoneRepository.findAll(pageable);
		return pageResult.toList();
	}
	
	public Telefone findTelefondeByID(Long id){
		Optional<Telefone> findByID = telefoneRepository.findById(id);
		Telefone tel = null;
		if (!findByID.isPresent()) {
			throw new RuntimeException("Telefone com ID ["+id+"] " + HttpStatus.NOT_FOUND + " ");
		}
		tel = findByID.get();
		return tel;
	}
	
	public Telefone updateTelefone(Long id, TelefoneDTO telDTO) {
		Telefone tel = findTelefondeByID(id);
		tel.setDdd(telDTO.getDdd());
		tel.setNumero(telDTO.getNumero());
		tel.setRamal(telDTO.getRamal());
		tel.setTipo(telDTO.getTipo());
		tel.setDono(tel.getDono());
		
		return telefoneRepository.save(tel);
	}
}
