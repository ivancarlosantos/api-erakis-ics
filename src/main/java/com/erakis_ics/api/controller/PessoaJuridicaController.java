package com.erakis_ics.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.entity.PessoaJuridica;
import com.erakis_ics.api.services.PessoaJuridicaServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Erakis ICS API")
@RestController
@RequestMapping(path = "/api")
public class PessoaJuridicaController {

	@Autowired
	private PessoaJuridicaServices pessoaJuridicaServices;

	@GetMapping(path = "/status")
	@ApiOperation(value = "Retorna Status de Conexão 200 OK, Se ativo")
	public String status() {
		return "STATUS: " + HttpStatus.OK + " CONNECTION ACCEPT INITIALIZER TOMCAT SERVER PORT: 8090 - Session Time: "
				+ pessoaJuridicaServices.TimeSession();
	}

	@PostMapping(path = "/pessoajuridica/save")
	@ApiOperation(value = "Cadastra uma Pessoa Jurídica")
	public PessoaJuridica save(@RequestBody PessoaJuridica pj) {
		return pessoaJuridicaServices.savePessoaJuridica(pj);
	}

	@GetMapping(path = "/pessoajuridica/listPessoaJuridicaTodos")
	@ApiOperation(value = "Lista todas as Pessoa Jurídicas")
	public List<PessoaJuridica> listPessoaJuridicaAll() throws RuntimeException {
		return pessoaJuridicaServices.findPJAll();
	}

	@GetMapping(path = "/pessoajuridica/findPJByCNPJ/{psjur_cnpj}")
	@ApiOperation(value = "Retorna Pessoa Jurídica por CNPJ")
	public List<PessoaJuridica> findPJByCNPJ(@PathVariable String psjur_cnpj) {
		List<PessoaJuridica> pj = pessoaJuridicaServices.findPJByCNPJ(psjur_cnpj);
		return pj;
	}

	@GetMapping(path = "/pessoajuridica/findPJByRazaoSocial/{psjur_razao_social}")
	@ApiOperation(value = "Retorna Pessoa Jurídica por Razão Social")
	public Optional<PessoaJuridica> findPJByRazaoSocial(@PathVariable String psjur_razao_social) {
		Optional<PessoaJuridica> pj = pessoaJuridicaServices.findPJByRazaoSocial(psjur_razao_social);
		return pj;
	}

	@GetMapping(path = "/pessoajuridica/findPJByNomeFantasia/{psjur_nome_fantasia}")
	@ApiOperation(value = "Retorna Pessoa Jurídica por Nome Fantasia")
	public Optional<PessoaJuridica> findPJByNomeFantasia(@PathVariable String psjur_nome_fantasia) {
		Optional<PessoaJuridica> pj = pessoaJuridicaServices.findPJByNomeFantasia(psjur_nome_fantasia);
		return pj;
	}

	@GetMapping(path = "/pessoajuridica/findPJByID/{psjur_id}")
	@ApiOperation(value = "Retorna Pessoa Jurídica pelo identificado ID")
	public PessoaJuridica findPJByID(@PathVariable(name = "psjur_id", required = true) Long psjur_id)
			throws RuntimeException {
		return pessoaJuridicaServices.findPJByID(psjur_id);
	}

	@PutMapping(path = "/pessoajuridica/update/{psjur_id}")
	@ApiOperation(value = "Atualiza os registros de uma Pessoa Jurídica")
	public ResponseEntity<PessoaJuridica> update(@PathVariable Long psjur_id, @RequestBody PessoaJuridica pj)
			throws RuntimeException {
		PessoaJuridica pessoaJuridica = pessoaJuridicaServices.updatePessoaJuridica(psjur_id, pj);
		return ResponseEntity.ok().body(pessoaJuridica);
	}

	@DeleteMapping(path = "/pessoajuridica/delete/{psjur_id}")
	@ApiOperation(value = "Deleta uma Pessoa Jurídica por ID")
	public void delete(@PathVariable(name = "psjur_id", required = true) Long psjur_id, PessoaJuridica pj) {
		pessoaJuridicaServices.deletePessoaJuridica(psjur_id, pj);
		ResponseEntity.ok(HttpStatus.GONE);
	}
}
