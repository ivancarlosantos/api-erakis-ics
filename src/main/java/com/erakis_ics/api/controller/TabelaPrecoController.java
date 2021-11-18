package com.erakis_ics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.dtos.TabelaPrecoDTO;
import com.erakis_ics.api.services.TabelaPrecoServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class TabelaPrecoController {

	@Autowired
	private TabelaPrecoServices tabelaPrecoServices;
	
	
	@GetMapping(path = "/tabelapreco/listTabelaPrecoAll")
	@ApiOperation(value = "lista a tabela de preço")
	public ResponseEntity<List<TabelaPrecoDTO>> findTPAll(){
		List<TabelaPrecoDTO> list = tabelaPrecoServices.findTPAll();
		return ResponseEntity.ok().body(list);
	}
}
