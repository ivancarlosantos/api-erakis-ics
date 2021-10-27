package com.erakis_ics.api.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class StatusController {

	@GetMapping(path = "/status")
	@ApiOperation(value = "Retorna Status de Conexão 200 OK, Se ativo")
	public String status() {
		return "STATUS: " + HttpStatus.OK + " CONNECTION ACCEPT START TOMCAT SERVER PORT: 8090 - Session Time: "
				          + timeSession();
	}

	private static Date timeSession() {
		return new Date(System.currentTimeMillis());
	}
}
