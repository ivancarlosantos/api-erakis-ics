package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.erakis_ics.api.entity.Municipio;

public class MunicipioDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer ibge;
	//private Estado estado;
	private String descricao;
	
	public MunicipioDTO() {
	}

	public MunicipioDTO(Municipio mun) {
		this.id = mun.getId();
		this.ibge = mun.getIbge();
		//this.estado = mun.getEstado();
		this.descricao = mun.getDescricao();
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

	/*
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	} */

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		MunicipioDTO other = (MunicipioDTO) obj;
		return Objects.equals(id, other.id);
	}	
}
