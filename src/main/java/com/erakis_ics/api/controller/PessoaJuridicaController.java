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

import com.erakis_ics.api.dtos.PessoaJuridicaDTO;
import com.erakis_ics.api.entity.PessoaJuridica;
import com.erakis_ics.api.services.PessoaJuridicaServices;
import com.erakis_ics.api.status.StatusPessoaJuridica;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class PessoaJuridicaController {

	@Autowired
	private PessoaJuridicaServices pessoaJuridicaServices;

	@PostMapping(path = "/pessoajuridica/save")
	@ApiOperation(value = "Cadastra uma Pessoa Jurídica")
	public ResponseEntity<PessoaJuridicaDTO> save(@RequestBody PessoaJuridica pj) {
		PessoaJuridica pessoaJuridica = pessoaJuridicaServices.savePessoaJuridica(pj);
		PessoaJuridicaDTO pjDTO = new PessoaJuridicaDTO(pessoaJuridica);
		return ResponseEntity.ok().body(pjDTO);
	}
	
	@GetMapping(path = "/pessoajuridica/listPessoaJuridicaTodos")
	@ApiOperation(value = "Lista todas as pessoas jurídicas")
	public ResponseEntity<List<PessoaJuridicaDTO>> listPessoaJuridicaAll(){
		List<PessoaJuridicaDTO> listAll = pessoaJuridicaServices.findPJAll();
		return ResponseEntity.ok().body(listAll);
	}

	@GetMapping(path = "/pessoajuridica/listPessoaJuridica/{numberPage}")
	@ApiOperation(value = "Lista todas as Pessoa Jurídicas por paginação")
	public ResponseEntity<?> listPessoaJuridicaAll(
			@PathVariable Integer numberPage) {
		StatusPessoaJuridica dto = new StatusPessoaJuridica();
		List<PessoaJuridica> listPJ = pessoaJuridicaServices.findPJAll(numberPage,10);
		dto.setHttp_response(HttpStatus.OK);
		dto.setNumber_http_response(HttpStatus.OK.value());
		dto.setPessoas_juridica(listPJ);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(path = "/pessoajuridica/findPJByID/{psjur_id}")
	@ApiOperation(value = "Retorna Pessoa Jurídica pelo identificador ID")
	public ResponseEntity<PessoaJuridicaDTO> findPJByID(
			@PathVariable(name = "psjur_id", required = true) Long psjur_id) {
		PessoaJuridica pj = pessoaJuridicaServices.findPJByID(psjur_id);
		PessoaJuridicaDTO pjDTO = new PessoaJuridicaDTO(pj);
		return ResponseEntity.ok().body(pjDTO);
	}

	@GetMapping(path = "/pessoajuridica/findPJByCNPJ/{psjur_cnpj}")
	@ApiOperation(value = "Retorna Pessoa Jurídica por CNPJ")
	public ResponseEntity<Optional<PessoaJuridicaDTO>> findPJByCNPJ(
			@PathVariable(name = "psjur_cnpj", required = true) String psjur_cnpj) {
		Optional<PessoaJuridicaDTO> listPJCNPJ = pessoaJuridicaServices.findPJByCNPJ(psjur_cnpj);
		return ResponseEntity.ok().body(listPJCNPJ);
	}

	@GetMapping(path = "/pessoajuridica/findPJByRazaoSocial/{psjur_razao_social}")
	@ApiOperation(value = "Retorna Pessoa Jurídica por Razão Social")
	public ResponseEntity<Optional<PessoaJuridicaDTO>> findPJByRazaoSocial(
			@PathVariable(name = "psjur_razao_social", required = true) String psjur_razao_social) {
		Optional<PessoaJuridicaDTO> listPJ = pessoaJuridicaServices.findPJByRazaoSocial(psjur_razao_social);
		return ResponseEntity.ok().body(listPJ);
	}

	@GetMapping(path = "/pessoajuridica/findPJByNomeFantasia/{psjur_nome_fantasia}")
	@ApiOperation(value = "Retorna Pessoa Jurídica por Nome Fantasia")
	public ResponseEntity<Optional<PessoaJuridicaDTO>> findPJByNomeFantasia(
			@PathVariable(name = "psjur_nome_fantasia", required = true) String psjur_nome_fantasia) {
		Optional<PessoaJuridicaDTO> listPJ = pessoaJuridicaServices.findPJByNomeFantasia(psjur_nome_fantasia);
		return ResponseEntity.ok().body(listPJ);
	}

	@PutMapping(path = "/pessoajuridica/update/{psjur_id}")
	@ApiOperation(value = "Atualiza os registros de uma Pessoa Jurídica")
	public ResponseEntity<PessoaJuridica> update(@PathVariable(name = "psjur_id", required = true) Long psjur_id,
			@RequestBody PessoaJuridicaDTO pjDTO) {
		PessoaJuridica pj = pessoaJuridicaServices.updatePessoaJuridica(psjur_id, pjDTO);

		return ResponseEntity.ok().body(pj);
	}

	@DeleteMapping(path = "/pessoajuridica/delete/{psjur_id}")
	@ApiOperation(value = "Deleta uma Pessoa Jurídica por ID")
	public void delete(@PathVariable(name = "psjur_id", required = true) Long psjur_id, PessoaJuridicaDTO pjDTO) {
		pessoaJuridicaServices.deletePessoaJuridica(psjur_id, pjDTO);
		ResponseEntity.ok(HttpStatus.NO_CONTENT);
	}		
}
