package com.erakis_ics.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.dtos.EstadoDTO;
import com.erakis_ics.api.entity.Estado;
import com.erakis_ics.api.services.EstadoServices;
import com.erakis_ics.api.status.StatusEstado;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class EstadoController {

	@Autowired
	private EstadoServices estadoServices;
	
	@PostMapping(path = "/estados/save")
	@ApiOperation(value = "Cadastra um Estado Brasileiro")
	public ResponseEntity<EstadoDTO> saveEstado(@RequestBody Estado estado){
		Estado e = estadoServices.saveEstado(estado);
		EstadoDTO dto = new EstadoDTO(e);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(path = "/estados/listEstados")
	@ApiOperation(value = "Lista os estados Brasileiros cadastrados")
	public ResponseEntity<List<EstadoDTO>> listEstados(){
		List<EstadoDTO> listAll = estadoServices.listEstados();
		return ResponseEntity.ok().body(listAll);
	}
	
	@GetMapping(path = "/estados/listEstados/{numberPage}")
	@ApiOperation(value = "Lista os estados Brasileiros cadastrados por paginação")
	public ResponseEntity<?> listEstados(@PathVariable Integer numberPage){
		StatusEstado dto = new StatusEstado();
		List<Estado> listAll = estadoServices.listEstados(numberPage, 10);
		dto.setHttp_response(HttpStatus.OK);
		dto.setNumber_http_response(HttpStatus.OK.value());
		dto.setEstados(listAll);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(path = "/estados/findEstado/{est_sigla}")
	@ApiOperation(value = "Retorna um Estado por sua sigla")
	public ResponseEntity<EstadoDTO> findEstado(
			@PathVariable(name = "est_sigla", required = true) String est_sigla){
		Optional<Estado> findEstado = estadoServices.findBySigla(est_sigla);
		EstadoDTO dto = new EstadoDTO(findEstado.get());
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(path = "/estados/update/{estado}")
	@ApiOperation(value = "Atualiza os dados de um estado brasileiro")
	public ResponseEntity<Estado> updateEstado(@PathVariable(value = "id",required = true) Long id, @RequestBody EstadoDTO dto){
		Estado estado = estadoServices.updateEstado(id, dto);
		return ResponseEntity.ok().body(estado);
	}
}
