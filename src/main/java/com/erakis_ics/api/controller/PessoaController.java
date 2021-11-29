package com.erakis_ics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.entity.Pessoa;
import com.erakis_ics.api.services.PessoaServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class PessoaController {

	@Autowired
	PessoaServices pessoaServices;
	
	@GetMapping(path = "/pessoa/{pessoa_id}")
	@ApiOperation(value = "retorna os registros de uma pessoa")
	public ResponseEntity<List<Pessoa>> listPessoas(@PathVariable(name = "pessoa_id", required = true) Long pessoa_id){
		List<Pessoa> listAll = pessoaServices.listPessoa(pessoa_id);
		return ResponseEntity.ok().body(listAll);
	}
}
