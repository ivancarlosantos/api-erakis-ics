package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica implements Serializable {

	private static final long serialVersionUID = -6105756219868534161L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long psjur_id;
	
	@Column(name = "psjur_cnpj", nullable = false,length = 14)
	private String cnpj;

	@Column(name = "psjur_codigo_suframa",nullable = false,length = 255)
	private String codigoSuframa;
	
	@Column(name = "psjur_inscricao_estadual",nullable = false,length = 255)
	private String inscricaoEstadual;
	
	@Column(name = "psjur_inscricao_municipal",nullable = false,length = 255)
	private String inscricaoMunicipal;
	
	@Column(name = "psjur_nome_fantasia",nullable = false,length = 255)
	private String nomeFantasia;

	@Column(name = "psjur_razao_social",nullable = false,length = 255)
	private String razaoSocial;
	
	@Column(name = "psjur_sistema_tributario",nullable = false)
	private SistemaTributario sistemaTributario;

	@Column(name = "psjur_site",nullable = false,length = 255)
	private String site;
		
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

	public String getCodigoSuframa() {
		return codigoSuframa;
	}

	public void setCodigoSuframa(String codigoSuframa) {
		this.codigoSuframa = codigoSuframa;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
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

	public SistemaTributario getSistemaTributario() {
		return sistemaTributario;
	}

	public void setSistemaTributario(SistemaTributario sistemaTributario) {
		this.sistemaTributario = sistemaTributario;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, codigoSuframa, inscricaoEstadual, inscricaoMunicipal, nomeFantasia, psjur_id,
				razaoSocial, sistemaTributario, site);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaJuridica other = (PessoaJuridica) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(codigoSuframa, other.codigoSuframa)
				&& Objects.equals(inscricaoEstadual, other.inscricaoEstadual)
				&& Objects.equals(inscricaoMunicipal, other.inscricaoMunicipal)
				&& Objects.equals(nomeFantasia, other.nomeFantasia) && Objects.equals(psjur_id, other.psjur_id)
				&& Objects.equals(razaoSocial, other.razaoSocial) && sistemaTributario == other.sistemaTributario
				&& Objects.equals(site, other.site);
	}
	
}
