package com.erakis_ics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.dtos.EnderecoDTO;
import com.erakis_ics.api.entity.Endereco;
import com.erakis_ics.api.services.EnderecoServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class EnderecoController {
	
	@Autowired
	private EnderecoServices enderecoServices;
	
	@GetMapping(path = "/enderecos/listEnderecosTodos")
	@ApiOperation(value = "Lista os endereços cadastrados")
	public ResponseEntity<List<EnderecoDTO>> listEnderecos(){
		List<EnderecoDTO> listAll = enderecoServices.listEndereco();
		return ResponseEntity.ok().body(listAll);
	}
	
	@GetMapping(path = "/enderecos/listEnderecos/{numberPage}")
	@ApiOperation(value = "Lista os endereços cadastrados por paginação")
	public ResponseEntity<List<Endereco>> listEnderecos(@PathVariable Integer numberPage){
		List<Endereco> listAll = enderecoServices.listEndereco(numberPage, 12);
		return ResponseEntity.ok().body(listAll);
	}
}
