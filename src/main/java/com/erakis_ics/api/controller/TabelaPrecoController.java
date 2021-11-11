package com.erakis_ics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.erakis_ics.api.dtos.TabelaPrecoDTO;
import com.erakis_ics.api.services.TabelaPrecoServices;

import io.swagger.annotations.ApiOperation;

//@RestController
//@RequestMapping(path = "/api")
public class TabelaPrecoController {

	@Autowired
	private TabelaPrecoServices tabelaPrecoServices;
	
	@GetMapping(path = "/tabelapreco/listTabelaPrecoAll")
	@ApiOperation(value = "lista a tabela de preço")
	public ResponseEntity<TabelaPrecoDTO> findTPAll(){
		List<TabelaPrecoDTO> list = tabelaPrecoServices.findTPAll();
		TabelaPrecoDTO dto = new TabelaPrecoDTO();
		for (int i = 0;i<=list.size();i++) {
			dto.setTitulo(list.get(i).getTitulo());
			dto.setPrecos(list.get(i).getPrecos());
		}
		return ResponseEntity.ok().body(dto);
	}
}
