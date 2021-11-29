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

import com.erakis_ics.api.dtos.PessoaFisicaDTO;
import com.erakis_ics.api.entity.PessoaFisica;
import com.erakis_ics.api.services.PessoaFisicaServices;
import com.erakis_ics.api.status.StatusPessoaFisica;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class PessoaFisicaController {

	@Autowired
	private PessoaFisicaServices pessoaFisicaServices;

	@PostMapping(path = "/pessoafisica/save")
	@ApiOperation(value = "Cadastra uma Pessoa Física")
	public ResponseEntity<PessoaFisicaDTO> save(@RequestBody PessoaFisica pf) {
		PessoaFisica pessoaFisica = pessoaFisicaServices.savePessoaFisica(pf);
		PessoaFisicaDTO pfDTO = new PessoaFisicaDTO(pessoaFisica);
		return ResponseEntity.ok().body(pfDTO);
	}
	
	@GetMapping(path = "/pessoafisica/listPessoaFisicaTodos")
	@ApiOperation(value = "Lista todas as pessoas físicas")
	public ResponseEntity<List<PessoaFisicaDTO>> listPessoaFisicaAll(){
		List<PessoaFisicaDTO> listAll = pessoaFisicaServices.findPFAll();
		return ResponseEntity.ok().body(listAll);				
	}

	@GetMapping(path = "/pessoafisica/listPessoaFisica/{numberPage}")
	@ApiOperation(value = "Lista todas as Pessoa Físicas por paginação")
	public ResponseEntity<?> listPessoaFisicaAll(@PathVariable int numberPage) {
		StatusPessoaFisica dto = new StatusPessoaFisica();
		List<PessoaFisica> listPF = pessoaFisicaServices.findPFAll(numberPage, 12);
		dto.setHttp_response(HttpStatus.OK);
		dto.setNumber_http_response(HttpStatus.OK.value());
		dto.setPessoas_fisicas(listPF);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(path = "/pessoafisica/findPFByID/{psfis_id}")
	@ApiOperation(value = "Retorna Pessoa Física pelo identificador ID")
	public ResponseEntity<PessoaFisicaDTO> findPFByID(@PathVariable(name = "psfis_id", required = true) Long psfis_id) {
		PessoaFisica pf = pessoaFisicaServices.findPFByID(psfis_id);
		PessoaFisicaDTO pfDTO = new PessoaFisicaDTO(pf);
		return ResponseEntity.ok().body(pfDTO);
	}

	@GetMapping(path = "/pessoafisica/findPFByNome/{psfis_nome}")
	@ApiOperation(value = "Retorna Pessoa Física pelo seu nome")
	public ResponseEntity<PessoaFisicaDTO> findPFByNome(
			@PathVariable(name = "psfis_nome", required = true) String psfis_nome) {
		Optional<PessoaFisica> pf = pessoaFisicaServices.findPFByNome(psfis_nome);
		PessoaFisicaDTO pfDTO = new PessoaFisicaDTO(pf.get());
		return ResponseEntity.ok().body(pfDTO);
	}

	@GetMapping(path = "/pessoafisica/findPFByCPF/{psfis_cpf}")
	@ApiOperation(value = "Retorna Pessoa Física por CPF")
	public ResponseEntity<PessoaFisicaDTO> findPFByCPF(@PathVariable(name = "psfis_cpf") String psfis_cpf) {
		Optional<PessoaFisica> listPFCPF = pessoaFisicaServices.findPFByCPF(psfis_cpf);
		PessoaFisicaDTO pfDTO = new PessoaFisicaDTO(listPFCPF.get());
		return ResponseEntity.ok().body(pfDTO);
	}

	@PutMapping(path = "/pessoafisica/update/{psfis_id}")
	@ApiOperation(value = "Atualiza os registros de uma Pessoa Física")
	public ResponseEntity<PessoaFisica> update(@PathVariable(name = "psfis_id", required = true) Long psfis_id,
			@RequestBody PessoaFisicaDTO pfDTO) {
		PessoaFisica pessoaFisica = pessoaFisicaServices.updatePessoaFisica(psfis_id, pfDTO);
		return ResponseEntity.ok().body(pessoaFisica);
	}

	@DeleteMapping(path = "/pessoafisica/delete/{psfis_id}")
	@ApiOperation(value = "Deleta uma Pessoa Física por ID")
	public void delete(@PathVariable(name = "psfis_id", required = true) Long psfis_id, PessoaFisicaDTO pfDTO) {
		pessoaFisicaServices.deletePessoaFisica(psfis_id, pfDTO);
		ResponseEntity.ok(HttpStatus.NO_CONTENT);
	}
}
