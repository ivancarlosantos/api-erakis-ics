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

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long psjur_id;

	@Column(name = "psjur_cnpj", nullable = false, length = 14)
	private String cnpj;

	@Column(name = "psjur_codigo_suframa", length = 255)
	private String codigoSuframa;

	@Column(name = "psjur_inscricao_estadual", length = 255)
	private String inscricaoEstadual;

	@Column(name = "psjur_inscricao_municipal", length = 255)
	private String inscricaoMunicipal;

	@Column(name = "psjur_nome_fantasia", nullable = false, length = 255)
	private String nomeFantasia;

	@Column(name = "psjur_razao_social", nullable = false, length = 255)
	private String razaoSocial;

	@Column(name = "psjur_sistema_tributario")
	private SistemaTributario sistemaTributario;

	@Column(name = "psjur_site", length = 255)
	private String site;

	public PessoaJuridica() {
	}

	public PessoaJuridica(Long psjur_id, String cnpj, String codigoSuframa, String inscricaoEstadual,
			String inscricaoMunicipal, String nomeFantasia, String razaoSocial, SistemaTributario sistemaTributario,
			String site) {
		super();
		this.psjur_id = psjur_id;
		this.cnpj = cnpj;
		this.codigoSuframa = codigoSuframa;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.sistemaTributario = sistemaTributario;
		this.site = site;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(psjur_id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaJuridica other = (PessoaJuridica) obj;
		return Objects.equals(psjur_id, other.psjur_id);
	}
}
