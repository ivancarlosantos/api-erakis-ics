package com.erakis_ics.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.erakis_ics.api.dtos.TestMemoryDTO;

import io.swagger.annotations.ApiOperation;

//@RestController
//@RequestMapping(path = "/api")
public class TestMemoryController {


	@GetMapping(path = "/testmemory/test")
	@ApiOperation(value = "URI para teste e análise de consumo de memória do APP")
	public ResponseEntity<TestMemoryDTO> test_memory() {
		List<TestMemoryDTO> listTestMemoryDTO = new ArrayList<>();
		//List<PessoaJuridicaDTO> pjDTO = pessoaJuridicaServices.findPJAll(1,2);
		TestMemoryDTO t = new TestMemoryDTO();

		if (!listTestMemoryDTO.isEmpty()) {
			
			t.setNumber_http_response(HttpStatus.OK.value());
			t.setHttp_response(HttpStatus.OK);
			t.setMessages("[SUCCESS] " + new String(" REQUEST"));
			
			//t.setPessoas_juridicas(pjDTO);
			listTestMemoryDTO.add(t);

			return ResponseEntity.ok().body(t);
		} else {

			t.setNumber_http_response(HttpStatus.BAD_REQUEST.value());
			t.setHttp_response(HttpStatus.BAD_REQUEST);
			t.setMessages("[ERROR] " + new String("BAD REQUEST"));
			t.setPessoas_juridicas(null);
			listTestMemoryDTO.add(t);

			return ResponseEntity.ok().body(t);
		}
	}
}