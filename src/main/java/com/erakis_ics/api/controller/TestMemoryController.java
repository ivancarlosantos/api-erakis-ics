package com.erakis_ics.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.dtos.PessoaJuridicaDTO;
import com.erakis_ics.api.dtos.TestMemoryDTO;
import com.erakis_ics.api.services.PessoaJuridicaServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class TestMemoryController {

	@Autowired
	private PessoaJuridicaServices pessoaJuridicaServices;

	@GetMapping(path = "/testmemory/test")
	@ApiOperation(value = "URL para teste e análise de consumo de memória APP")
	public ResponseEntity<List<TestMemoryDTO>> test_memory() {
		List<TestMemoryDTO> l = new ArrayList<>();
		List<PessoaJuridicaDTO> dto = pessoaJuridicaServices.findPJAll();
		TestMemoryDTO t = new TestMemoryDTO();

		if (!dto.isEmpty()) {
			t.setNumber_http_response(HttpStatus.OK.value());
			t.setHttp_response(HttpStatus.OK);
			t.setMessages("[SUCCESS] " + new String("TEST REQUEST"));
			t.setTime_stamp(new Date(System.currentTimeMillis()));
			t.setPessoas_juridicas(dto);
			l.add(t); 

			return ResponseEntity.ok().body(l);
		} else {
			
			t.setNumber_http_response(HttpStatus.BAD_REQUEST.value());
			t.setHttp_response(HttpStatus.BAD_REQUEST);
			t.setMessages("[ERROR] " + new String("BAD REQUEST"));
			t.setTime_stamp(new Date(System.currentTimeMillis()));
			t.setPessoas_juridicas(null);
			l.add(t); 
			
			return ResponseEntity.ok().body(l);
		}
	}
}