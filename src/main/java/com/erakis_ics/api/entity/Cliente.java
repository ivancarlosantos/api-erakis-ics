package com.erakis_ics.api.entity;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

	private Long id;
	private Pessoa pessoa;
	private String observacao;
	private Set<PessoaFisica> contatos = new HashSet<PessoaFisica>();		
	private Long codigoNumerico;
	private String codigo;
	private String nome;
	private String cnpj;
	private String email;
	private String tipo;
	private String municipio;
	
	public Cliente() {
	}

	public Cliente(Long id, Pessoa pessoa, String observacao, Set<PessoaFisica> contatos, Long codigoNumerico,
			       String codigo, String nome, String cnpj, String email, String tipo, String municipio) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.observacao = observacao;
		this.contatos = contatos;
		this.codigoNumerico = codigoNumerico;
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.tipo = tipo;
		this.municipio = municipio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Set<PessoaFisica> getContatos() {
		return contatos;
	}

	public void setContatos(Set<PessoaFisica> contatos) {
		this.contatos = contatos;
	}

	public Long getCodigoNumerico() {
		return codigoNumerico;
	}

	public void setCodigoNumerico(Long codigoNumerico) {
		this.codigoNumerico = codigoNumerico;
	}
}
