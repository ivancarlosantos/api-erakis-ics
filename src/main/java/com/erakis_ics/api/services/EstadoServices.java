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

	public List<EstadoDTO> listEstados() {
		List<EstadoDTO> listAll = estadoRepository
								  .findAll(Sort.by("descricao"))
								  .stream()
								  .map(est -> new EstadoDTO(est))
								  .collect(Collectors.toList());
		return listAll;
	}

	public List<Estado> listEstados(int pageNumber, int pageSize) {
		Sort sort = Sort.by("descricao");
		Pageable page = PageRequest.of(pageNumber, pageSize, sort);
		Page<Estado> pageResult = estadoRepository.findAll(page);
		return pageResult.toList();
	}

	public Optional<Estado> findBySigla(String estado) {
		Optional<Estado> findEstado = estadoRepository.findBySigla(estado);
		if (findEstado.isPresent()) {
		} else {
			throw new RuntimeException("Estado não cadastrado e/ou não encontrado");
		}

		return findEstado;
	}

	public Estado findEstadoByID(Long id) {
		Optional<Estado> findByID = estadoRepository.findById(id);
		Estado estado = null;
		if (!findByID.isPresent()) {
			throw new RuntimeException("Estado com ID = [" + id + "] " + HttpStatus.NOT_FOUND);
		}
		estado = findByID.get();
		return estado;
	}
	
	public Estado updateEstado(Long id, EstadoDTO dto) {
		Estado estado = findEstadoByID(id);
		estado.setIbge(dto.getIbge());
		estado.setDescricao(dto.getDescricao());
		estado.setSigla(dto.getSigla());
		estado.setRegiao(dto.getRegiao());
		estado.setIcms(dto.getIcms());
		estado.setStAntecipada(dto.isStAntecipada());
		estado.setBaseDupla(dto.getBaseDupla());
		estado.setBaseDuplaConv(dto.getBaseDuplaConv());
		
		return estadoRepository.save(estado);
	}
	
	public void deleteEstado(Long id,EstadoDTO dto) {
		if (dto.getId() == null || id < 0) {
			throw new RuntimeException("Estado com ID = [" + id + "] " + HttpStatus.NOT_FOUND);
		}
		estadoRepository.deleteById(dto.getId());
	}

}
