package com.erakis_ics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.dtos.TabelaPrecoDTO;
import com.erakis_ics.api.entity.TabelaPreco;
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
	
	@GetMapping(path = "/tabelapreco/listTabelaPreco/{pageNumber}")
	@ApiOperation(value = "retorna tabela de preço por paginação")
	public ResponseEntity<List<TabelaPreco>> findTPAll(@PathVariable Integer pageNumber){
		List<TabelaPreco> listAll = tabelaPrecoServices.listTabela(pageNumber, 9);
		return ResponseEntity.ok().body(listAll);
	}

}
