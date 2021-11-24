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
@Table(name = "estado")
public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "est_id")
	private Long id;
	
	@Column(name = "est_ibge", unique = true)
	private Integer ibge;
	
	@Column(name = "est_descricao")
	private String descricao;
	
	@Column(name = "est_sigla")
	private String sigla;
	
	@Column(name = "est_regiao")
	private Regiao regiao;
	
	@Column(name = "est_icms")
	private Double icms;
	
	@Column(name = "est_st_antecipada")
	private boolean stAntecipada;
	
	//@OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY,mappedBy = "estado")
	//private Set<Municipio> municipios = new HashSet<Municipio>(0);
	
	@Column(name = "est_base_dupla")
	private Boolean baseDupla;
	
	@Column(name = "est_base_dupla_conv")
	private Boolean baseDuplaConv;

	public Estado() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIbge() {
		return ibge;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public Double getIcms() {
		return icms;
	}

	public void setIcms(Double icms) {
		this.icms = icms;
	}

	public boolean isStAntecipada() {
		return stAntecipada;
	}

	public void setStAntecipada(boolean stAntecipada) {
		this.stAntecipada = stAntecipada;
	}

	/*public Set<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(Set<Municipio> municipios) {
		this.municipios = municipios;
	} */

	public Boolean getBaseDupla() {
		return baseDupla;
	}

	public void setBaseDupla(Boolean baseDupla) {
		this.baseDupla = baseDupla;
	}

	public Boolean getBaseDuplaConv() {
		return baseDuplaConv;
	}

	public void setBaseDuplaConv(Boolean baseDuplaConv) {
		this.baseDuplaConv = baseDuplaConv;
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
		Estado other = (Estado) obj;
		return Objects.equals(id, other.id);
	}
}
