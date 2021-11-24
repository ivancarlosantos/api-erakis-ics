package com.erakis_ics.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.EstadoDTO;
import com.erakis_ics.api.entity.Estado;
import com.erakis_ics.api.repository.EstadoRepository;

@Service
public class EstadoServices {

	@Autowired
	private EstadoRepository estadoRepository;

	public Estado saveEstado(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public List<EstadoDTO> listEstados(){
		List<EstadoDTO> listAll = estadoRepository
								  .findAll()
								  .stream()
								  .map(est->new EstadoDTO(est))
								  .collect(Collectors.toList());
		return listAll;
	}
	
	public List<Estado> listEstados(int pageNumber, int pageSize){
		Sort sort = Sort.by("descricao");
		Pageable page = PageRequest.of(pageNumber, pageSize, sort);
		Page<Estado> pageResult = estadoRepository.findAll(page);
		return pageResult.toList();
	}
	
	public Optional<Estado> findBySigla(String estado){
		Optional<Estado> findEstado = estadoRepository.findBySigla(estado);
		if (findEstado.isPresent()) {
		}else {
			throw new RuntimeException("Estado não cadastrado e/ou não encontrado");
		}
		
		return findEstado;
	}
}
