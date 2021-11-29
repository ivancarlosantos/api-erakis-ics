package com.erakis_ics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.dtos.TelefoneDTO;
import com.erakis_ics.api.entity.Telefone;
import com.erakis_ics.api.services.TelefoneServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class TelefoneController {

	@Autowired
	private TelefoneServices telefoneServices;
	
	@GetMapping(path = "/telefones/listTelefonesAll")
	@ApiOperation(value = "Retorna todos os telefones cadastrados")
	public ResponseEntity<List<TelefoneDTO>> listTelefones(){
		List<TelefoneDTO> listAll = telefoneServices.listTelefonesAll();
		System.out.println(listAll);
		return ResponseEntity.ok().body(listAll);
	}
	
	/*@GetMapping(path = "/telefones/{}")
	@ApiOperation(value = "retorna os registros de uma pessoa")
	public ResponseEntity<List<Telefone>> listPessoas(@PathVariable(name = "pessoa_id", required = true) Long pessoa_id){
		List<Telefone> listAll = telefoneServices.listTelefonesAll();
		return ResponseEntity.ok().body(listAll);
	}*/
	
	@GetMapping(path = "/telefones/listTelefones/{numberPage}")
	@ApiOperation(value = "Retorna todos os telefones cadastrados por paginação")
	public ResponseEntity<List<Telefone>> listTelefones(@PathVariable Integer numberPage){
		List<Telefone> listTel = telefoneServices.listTelefones(numberPage, 10);
		return ResponseEntity.ok().body(listTel);
	}
	
	@GetMapping(path = "/telefone/findTelefoneByID/{tel_id}")
	@ApiOperation(value = "Retorna Telefone Cadastrado pelo identificador ID")
	public ResponseEntity<TelefoneDTO> findTelefoneByID(@PathVariable Long tel_id){
		Telefone tel = telefoneServices.findTelefondeByID(tel_id);
		TelefoneDTO dto = new TelefoneDTO(tel);
		return ResponseEntity.ok().body(dto);
	}
}
