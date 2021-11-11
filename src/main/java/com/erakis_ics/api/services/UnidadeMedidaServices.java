package com.erakis_ics.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.UnidadeMedidaDTO;
import com.erakis_ics.api.entity.UnidadeMedida;
import com.erakis_ics.api.repository.UnidadeMedidaRepository;

@Service
public class UnidadeMedidaServices {

	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;

	public UnidadeMedida saveUnidadeMedida(UnidadeMedida um) {
		return unidadeMedidaRepository.save(um);
	}

	public List<UnidadeMedidaDTO> listUnidadeMedidaAll() {
		List<UnidadeMedidaDTO> listAll = unidadeMedidaRepository
									  .findAll(Sort.by("descricao"))
									  .stream()
									  .map(um -> new UnidadeMedidaDTO(um))
									  .collect(Collectors.toList());
		return listAll;
	}
	
	public UnidadeMedida findUMByID(Long id) {
		Optional<UnidadeMedida> findByID = unidadeMedidaRepository.findById(id);
		UnidadeMedida um = null;
		if (!findByID.isPresent()) {
			throw new RuntimeException("Unidade de Medida = [" + id + "] " + HttpStatus.NOT_FOUND + " ");
		}
		um = findByID.get();

		return um;
	}
	
	public UnidadeMedida updateUnidadeMedida(Long id, UnidadeMedidaDTO umDTO){
		UnidadeMedida um = findUMByID(id);
		um.setDescricao(umDTO.getDescricao());
		um.setAbreviatura(umDTO.getAbreviatura());
		um.setAbreviaturaExportacao(umDTO.getAbreviaturaExportacao());
		um.setCodigoInteligente(umDTO.isCodigoInteligente());
		um.setDescricaoInteligente(umDTO.isDescricaoInteligente());
		um.setEditavel(umDTO.isEditavel());
		
		return unidadeMedidaRepository.save(um);
	}
	
	public void deleteUnidadeMedida(Long id, UnidadeMedidaDTO umDTO) {
		if(id == null) {
			throw new RuntimeException("Unidade de Medida não encontrada"); 
		}
		unidadeMedidaRepository.deleteById(id);
	}
}
