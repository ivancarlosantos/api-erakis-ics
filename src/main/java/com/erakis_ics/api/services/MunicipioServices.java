package com.erakis_ics.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.MunicipioDTO;
import com.erakis_ics.api.entity.Municipio;
import com.erakis_ics.api.repository.MunicipioRepository;

@Service
public class MunicipioServices {

	@Autowired
	private MunicipioRepository municipioRepository;

	public Municipio saveMunicipio(Municipio mun) {
		return municipioRepository.save(mun);
	}
	
	public List<MunicipioDTO> listMunicipios(){
		List<MunicipioDTO> listAll = municipioRepository
									.findAll()
									.stream()
									.map(mun->new MunicipioDTO(mun))
									.collect(Collectors.toList());
	  return listAll;
	}
	
	public List<Municipio> listMunicipios(int pageNumber, int pageSize){
		Sort sort = Sort.by("descricao");
		Pageable page = PageRequest.of(pageNumber, pageSize, sort);
		Page<Municipio> pageResult = municipioRepository.findAll(page);
		return pageResult.toList();
	}
	
	
}
