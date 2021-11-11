package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comercializavel")
@Inheritance(strategy = InheritanceType.JOINED)
public class Comercializavel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cmrc_id")
	private Long id;

	@Column(name = "cmrc_codigo_principal")
	private String codigoPrincipal;
	
	@Column(name = "cmrc_codigo_pesquisa")
	private String codigoPesquisa;
	
	@Column(name = "cmrc_codigo_barras")
	private String codigoBarras;
	
	@Column(name = "cmrc_descricao_nota_fiscal")
	private String descricaoNotaFiscal;
	
	@Column(name = "cmrc_descricao_completa", columnDefinition = "TEXT")
	private String descricaoCompleta;
	
	@Column(name = "cmrc_exclusao_garantiaa", columnDefinition = "TEXT")
	private String exclusaoGarantia;
	
	@Column(name = "cmrc_preco_base", precision = 19,scale = 4)
	private BigDecimal precoBase;
	
	@Column(name = "cmrc_comissao")
	private Double comissao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comercializavel")
	private Set<PrecoComercializavel> precos = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoPrincipal() {
		return codigoPrincipal;
	}

	public void setCodigoPrincipal(String codigoPrincipal) {
		this.codigoPrincipal = codigoPrincipal;
	}

	public String getCodigoPesquisa() {
		return codigoPesquisa;
	}

	public void setCodigoPesquisa(String codigoPesquisa) {
		this.codigoPesquisa = codigoPesquisa;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDescricaoNotaFiscal() {
		return descricaoNotaFiscal;
	}

	public void setDescricaoNotaFiscal(String descricaoNotaFiscal) {
		this.descricaoNotaFiscal = descricaoNotaFiscal;
	}

	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}

	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}

	public String getExclusaoGarantia() {
		return exclusaoGarantia;
	}

	public void setExclusaoGarantia(String exclusaoGarantia) {
		this.exclusaoGarantia = exclusaoGarantia;
	}

	public BigDecimal getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(BigDecimal precoBase) {
		this.precoBase = precoBase;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Set<PrecoComercializavel> getPrecos() {
		return precos;
	}

	public void setPrecos(Set<PrecoComercializavel> precos) {
		this.precos = precos;
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
		Comercializavel other = (Comercializavel) obj;
		return Objects.equals(id, other.id);
	}
}
