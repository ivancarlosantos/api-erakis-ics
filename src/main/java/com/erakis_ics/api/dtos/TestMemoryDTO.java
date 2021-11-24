package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.erakis_ics.api.entity.PessoaFisica;
import com.erakis_ics.api.entity.PessoaJuridica;

public class TestMemoryDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//private Long test_id;
	
	private Integer number_http_response;
	
	private HttpStatus http_response;
	
	private String messages;
	
	private List<PessoaJuridica> pessoas_juridicas;
	
	private List<PessoaFisica> pessoas_fisicas;
	
	//private List<UnidadeMedida> unidade_medida;
	
	//private List<Endereco> endereco;
	
	///private List<Estado> estado;
	
	//private List<Municipio> municipio;
	
	//private List<Telefone> telefone;
	
	public TestMemoryDTO() {
	}

	public Integer getNumber_http_response() {
		return number_http_response;
	}

	public void setNumber_http_response(Integer number_http_response) {
		this.number_http_response = number_http_response;
	}
	
	public HttpStatus getHttp_response() {
		return http_response;
	}

	public void setHttp_response(HttpStatus http_response) {
		this.http_response = http_response;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public List<PessoaJuridica> getPessoas_juridicas() {
		return pessoas_juridicas;
	}

	public void setPessoas_juridicas(List<PessoaJuridica> listPJ) {
		this.pessoas_juridicas = listPJ;
	}

	public List<PessoaFisica> getPessoas_fisicas() {
		return pessoas_fisicas;
	}

	public void setPessoas_fisicas(List<PessoaFisica> pessoas_fisicas) {
		this.pessoas_fisicas = pessoas_fisicas;
	}

	/*
	public List<UnidadeMedida> getUnidade_medida() {
		return unidade_medida;
	}

	public void setUnidade_medida(List<UnidadeMedida> unidade_medida) {
		this.unidade_medida = unidade_medida;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public List<Estado> getEstado() {
		return estado;
	}

	public void setEstado(List<Estado> estado) {
		this.estado = estado;
	}
	
	public List<Municipio> getMunicipio() {
		return municipio;
	}

	public void setMunicipio(List<Municipio> municipio) {
		this.municipio = municipio;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	} */	
}