package com.erakis_ics.api.dtos;

import java.io.Serializable;

import com.erakis_ics.api.entity.PessoaJuridica;

public class PessoaJuridicaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long psjur_id;
	private String cnpj;
	private String nomeFantasia;
	private String razaoSocial;
	private String site;

	public PessoaJuridicaDTO() {
	}
	
	public PessoaJuridicaDTO(PessoaJuridica pj) {
		this.psjur_id = pj.getPsjur_id();
		this.cnpj = pj.getCnpj();
		this.nomeFantasia = pj.getNomeFantasia();
		this.razaoSocial = pj.getRazaoSocial();
		this.site = pj.getSite();
	} 
	
	public Long getPsjur_id() {
		return psjur_id;
	}

	public void setPsjur_id(Long psjur_id) {
		this.psjur_id = psjur_id;
	} 

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	} 
}
