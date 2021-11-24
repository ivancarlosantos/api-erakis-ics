package com.erakis_ics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.dtos.MunicipioDTO;
import com.erakis_ics.api.entity.Municipio;
import com.erakis_ics.api.services.MunicipioServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class MunicipioController {

	@Autowired
	private MunicipioServices municipioServices;
	
	@GetMapping(path = "/municipio/save")
	@ApiOperation(value = "Cadastra um novo município")
	public ResponseEntity<MunicipioDTO> saveMunicipio(@RequestBody Municipio mun) {
		Municipio municipio = municipioServices.saveMunicipio(mun);
		MunicipioDTO dto = new MunicipioDTO(municipio);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(path = "/municipio/listMunicipios")
	@ApiOperation(value = "Lista todos os municípios cadastrados")
	public ResponseEntity<List<MunicipioDTO>> listMunicipios(){
		List<MunicipioDTO> listAll = municipioServices.listMunicipios();
		return ResponseEntity.ok().body(listAll);
	}
	
	@GetMapping(path = "/municipio/listMunicipios/{numberPage}")
	@ApiOperation(value = "Lista todos os municípios cadastrados por paginação")
	public ResponseEntity<List<Municipio>> listMunicipios(@PathVariable Integer numberPage){
		List<Municipio> listAll = municipioServices.listMunicipios(numberPage,12);
		return ResponseEntity.ok().body(listAll);
	}
	
	
	
}
