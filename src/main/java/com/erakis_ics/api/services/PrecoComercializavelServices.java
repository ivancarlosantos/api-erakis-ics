package com.erakis_ics.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.PrecoComercializavelDTO;
import com.erakis_ics.api.entity.PrecoComercializavel;
import com.erakis_ics.api.repository.PrecoComercializavelRepository;

@Service
public class PrecoComercializavelServices {

	@Autowired
	private PrecoComercializavelRepository precoComercializavelRepository;
	
	public PrecoComercializavel savePrecoComercializavel(PrecoComercializavel pc) {
		
		return precoComercializavelRepository.save(pc);
	}
	
	public List<PrecoComercializavelDTO> listPrecos() {
		List<PrecoComercializavelDTO> listAll = precoComercializavelRepository
												.findAll(Sort.by("descricao"))
												.subList(1, 15)
												.stream()
												.map(pcDTO-> new PrecoComercializavelDTO(pcDTO))
												.collect(Collectors.toList());
		return listAll;
	}
	
	public PrecoComercializavel findByID(Long id) {
		Optional<PrecoComercializavel> findPCByID = precoComercializavelRepository.findById(id);
		PrecoComercializavel pc = null;
		if(findPCByID.isPresent()) {
			throw new RuntimeException("Registro não encontrado");
		}
		
		pc = findPCByID.get();
		
		return pc;
	}
	
	public PrecoComercializavel updatePrecoComercializavel(Long id, PrecoComercializavelDTO pcDTO) {
		PrecoComercializavel pc = findByID(id);
		pc.setCodigo(pcDTO.getCodigo());
		pc.setDescricao(pcDTO.getDescricao());
		//pc.setTabelaPreco(pcDTO.getTabelaPreco());
		//pc.setComercializavel(pcDTO.getComercializavel());
		pc.setValorUnitario(pcDTO.getValorUnitario());
		pc.setValorUnidadeMedida(pcDTO.getValorUnidadeMedida());
		//pc.setValorEmbalagem(pcDTO.getValorEmbalagem());
		//pc.setUnidadeMedida(pcDTO.getUnidadeMedida());
		//pc.setVariacao(pcDTO.getVariacao());
		//pc.setMultiplicidade(pcDTO.getMultiplicidade());
		//pc.setEmbalagem(pcDTO.getEmbalagem());
		//pc.setQuantidadeMinima(pcDTO.getQuantidadeMinima());
		
		return precoComercializavelRepository.save(pc);
	}
	
	public void deletePrecoComercializavel(Long id,PrecoComercializavelDTO pcDTO) {
		if(pcDTO.getId() == null || id < 0) {
			throw new RuntimeException("Registro não deletado");
		}
		precoComercializavelRepository.deleteById(pcDTO.getId());
	}
}
