package com.erakis_ics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.dtos.PrecoComercializavelDTO;
import com.erakis_ics.api.services.PrecoComercializavelServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class PrecoComercializavelController {

	@Autowired
	private PrecoComercializavelServices precoComercializavelServices;

	@GetMapping(path = "/precocomercializavel/listPrecosTodos")
	@ApiOperation(value = "lista todos os produtos e preços cadastrados")
	public ResponseEntity<List<PrecoComercializavelDTO>> listAll() {
		List<PrecoComercializavelDTO> listPCDTO = precoComercializavelServices.listPrecos();
		return ResponseEntity.ok().body(listPCDTO);
	}
}
