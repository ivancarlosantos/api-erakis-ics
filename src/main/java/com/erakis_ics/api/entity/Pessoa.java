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

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pess_id")
	private Long id;
	
	@Column(name = "pess_email")
	private String email;
	
	@Column(name = "pess_facebook")
	private String facebook;
	
	@Column(name = "pess_twitter")
	private String twitter;
	
	@Column(name = "pess_linkedin")
	private String linkedin;
	
	private Date parceiroDesde;
	
	@Column(name = "pess_observacao", columnDefinition = "TEXT")
	private String observacao;

	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private Cliente cliente;
	
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private Representante representante;
	
	@Column(name = "pess_codigo_numerico")
	private Long codigoNumerico;

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

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
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

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public Long getCodigoNumerico() {
		return codigoNumerico;
	}

	public void setCodigoNumerico(Long codigoNumerico) {
		this.codigoNumerico = codigoNumerico;
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
