package com.erakis_ics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.erakis_ics.api.dtos.VariacaoProdutoDTO;
import com.erakis_ics.api.services.VariacaoProdutoServices;

import io.swagger.annotations.ApiOperation;

//@RestController
//@RequestMapping(path = "/api")
public class VariacaoProdutoController {

	@Autowired
	private VariacaoProdutoServices variacaoProdutoServices;
	
	@GetMapping(path = "/variacaoproduto/listVariacaoProdutoAll")
	@ApiOperation(value = "lista todas as variações de produtos cadastradas")
	public ResponseEntity<List<VariacaoProdutoDTO>> listVariacaoProdutoAll(){
		List<VariacaoProdutoDTO> listAll = variacaoProdutoServices.findVPAll();
		return ResponseEntity.ok().body(listAll);
	}
}
