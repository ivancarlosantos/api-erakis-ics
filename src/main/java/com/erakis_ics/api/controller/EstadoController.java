package com.erakis_ics.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.dtos.EstadoDTO;
import com.erakis_ics.api.entity.Estado;
import com.erakis_ics.api.services.EstadoServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class EstadoController {

	@Autowired
	private EstadoServices estadoServices;
	
	@GetMapping(path = "/estados/listEstados")
	@ApiOperation(value = "Lista os estados Brasileiros cadastrados")
	public ResponseEntity<List<EstadoDTO>> listEstados(){
		List<EstadoDTO> listAll = estadoServices.listEstados();
		return ResponseEntity.ok().body(listAll);
	}
	
	@GetMapping(path = "/estados/listEstados/{numberPage}")
	@ApiOperation(value = "Lista os estados Brasileiros cadastrados por paginação")
	public ResponseEntity<List<Estado>> listEstados(@PathVariable Integer numberPage){
		List<Estado> listAll = estadoServices.listEstados(numberPage, 10);
		return ResponseEntity.ok().body(listAll);
	}
	
	@GetMapping(path = "/estados/findEstado/{est_sigla}")
	@ApiOperation(value = "Retorna um Estado por sua sigla")
	public ResponseEntity<EstadoDTO> findEstado(
			@PathVariable(name = "est_sigla", required = true) String est_sigla){
		Optional<Estado> findEstado = estadoServices.findBySigla(est_sigla);
		EstadoDTO dto = new EstadoDTO(findEstado.get());
		return ResponseEntity.ok().body(dto);
	}
}
