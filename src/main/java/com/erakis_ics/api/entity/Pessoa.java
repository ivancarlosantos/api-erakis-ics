package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pess_id")
	private Long id;
	
	@Column(name = "pess_email", length = 255)
	private String email;
	
	@Column(name = "pess_facebook",length = 255)
	private String facebook;
	
	@Column(name = "pess_linkedin", length = 255)
	private String linkedin;
	
	@Column(name = "pess_twitter", length = 255)
	private String twitter;
	
	private Date parceiroDesde;
	
	@Column(name = "pess_observacao", columnDefinition = "TEXT")
	private String observacao;
	
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	private Cliente cliente;

	@Column(name = "pess_codigo_numerico")
	private Long codigoNumerico;

	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Fornecedor fornecedor;

	public Pessoa() {
	}

	public Pessoa(Long id, String email, String facebook, String linkedin, String twitter, Date parceiroDesde,
			String observacao, Cliente cliente, Long codigoNumerico, Fornecedor fornecedor) {
		
		this.id = id;
		this.email = email;
		this.facebook = facebook;
		this.linkedin = linkedin;
		this.twitter = twitter;
		this.parceiroDesde = parceiroDesde;
		this.observacao = observacao;
		this.cliente = cliente;
		this.codigoNumerico = codigoNumerico;
		this.fornecedor = fornecedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public Date getParceiroDesde() {
		return parceiroDesde;
	}

	public void setParceiroDesde(Date parceiroDesde) {
		this.parceiroDesde = parceiroDesde;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getCodigoNumerico() {
		return codigoNumerico;
	}

	public void setCodigoNumerico(Long codigoNumerico) {
		this.codigoNumerico = codigoNumerico;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
}
