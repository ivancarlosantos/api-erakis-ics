package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.erakis_ics.api.entity.PessoaFisica;

public class StatusDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private HttpStatus http_response;
	private Integer number_http_response;
	private String messageRequest;
	private List<PessoaFisica> pessoas_fisicas;
	
	public HttpStatus getHttp_response() {
		return http_response;
	}
	
	public void setHttp_response(HttpStatus http_response) {
		this.http_response = http_response;
	}
	
	public Integer getNumber_http_response() {
		return number_http_response;
	}
	
	public void setNumber_http_response(Integer number_http_response) {
		this.number_http_response = number_http_response;
	}
	
	public String getMessageRequest() {
		return messageRequest;
	}
	
	public void setMessageRequest(String messageRequest) {
		this.messageRequest = messageRequest;
	}

	public List<PessoaFisica> getPessoas_fisicas() {
		return pessoas_fisicas;
	}

	public void setPessoas_fisicas(List<PessoaFisica> listPF) {
		this.pessoas_fisicas = listPF;
	}	
}
