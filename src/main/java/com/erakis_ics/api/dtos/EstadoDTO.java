package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.erakis_ics.api.entity.Estado;
import com.erakis_ics.api.entity.Regiao;

public class EstadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer ibge;
	private String descricao;
	private String sigla;
	private Regiao regiao;
	private Double icms;
	private boolean stAntecipada;
	//private List<Municipio> municipios = new ArrayList<>();
	private Boolean baseDupla;
	private Boolean baseDuplaConv;
	
	
	public EstadoDTO() {
	}


	public EstadoDTO(Estado est) {
		this.id = est.getId();
		this.ibge = est.getIbge();
		this.descricao = est.getDescricao();
		this.sigla = est.getSigla();
		this.regiao = est.getRegiao();
		this.icms = est.getIcms();
		this.stAntecipada = est.isStAntecipada();
		//this.municipios = est.getMunicipios();
		this.baseDupla = est.getBaseDupla();
		this.baseDuplaConv = est.getBaseDuplaConv();
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
		EstadoDTO other = (EstadoDTO) obj;
		return Objects.equals(id, other.id);
	}
}
