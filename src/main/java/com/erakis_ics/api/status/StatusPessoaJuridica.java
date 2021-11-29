package com.erakis_ics.api.status;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.erakis_ics.api.entity.PessoaJuridica;

public class StatusPessoaJuridica {

	private HttpStatus http_response;
	private Integer number_http_response;
	private List<PessoaJuridica> pessoas_juridica;
	
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

	public List<PessoaJuridica> getPessoas_juridica() {
		return pessoas_juridica;
	}

	public void setPessoas_juridica(List<PessoaJuridica> pessoas_juridica) {
		this.pessoas_juridica = pessoas_juridica;
	}
}
