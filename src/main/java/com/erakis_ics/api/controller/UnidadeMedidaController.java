package com.erakis_ics.api.controller;

import java.util.List;

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

import com.erakis_ics.api.dtos.UnidadeMedidaDTO;
import com.erakis_ics.api.entity.UnidadeMedida;
import com.erakis_ics.api.services.UnidadeMedidaServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class UnidadeMedidaController {

	@Autowired
	private UnidadeMedidaServices unidadeMedidaServices;
	
	@PostMapping(path = "/unidademedida/save")
	@ApiOperation(value = "Cadastra uma unidade de medida")
	public ResponseEntity<UnidadeMedidaDTO> save(@RequestBody UnidadeMedida um){
		UnidadeMedida unidMed = unidadeMedidaServices.saveUnidadeMedida(um);
		UnidadeMedidaDTO umDTO = new UnidadeMedidaDTO(unidMed);
		return ResponseEntity.ok().body(umDTO);
	}
	
	@GetMapping(path = "/unidademedida/listUnidadeMedidaTodos")
	@ApiOperation(value = "lista todas as unidades de medidas")
	public ResponseEntity<List<UnidadeMedidaDTO>> listUnidadeMedidaAll(){
		List<UnidadeMedidaDTO> listUMDTO = unidadeMedidaServices.listUnidadeMedidaAll();
		return ResponseEntity.ok().body(listUMDTO);
	}
	
	@PutMapping(path = "/unidademedida/update/{id}")
	@ApiOperation(value = "atualiza uma unidade de medida")
	public ResponseEntity<UnidadeMedida> update(@PathVariable(name = "id", required = true) Long id,
			@RequestBody UnidadeMedidaDTO umDTO){
		UnidadeMedida um = unidadeMedidaServices.updateUnidadeMedida(id, umDTO);
		return ResponseEntity.ok().body(um);
	}
	
	@DeleteMapping(path = "/unidademedida/delete/{id}")
	@ApiOperation(value = "exclui uma unidade de medida")
	public void delete(@PathVariable(name = "id", required = true) Long id,UnidadeMedidaDTO umDTO) {
		unidadeMedidaServices.deleteUnidadeMedida(id, umDTO);
		ResponseEntity.ok(HttpStatus.NO_CONTENT);
	}
}
