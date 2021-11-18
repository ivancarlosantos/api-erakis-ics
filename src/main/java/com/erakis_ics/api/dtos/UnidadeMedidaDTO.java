package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.erakis_ics.api.entity.UnidadeMedida;

public class UnidadeMedidaDTO implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	private String abreviatura;
	private String abreviaturaExportacao;	
	private boolean codigoInteligente;
	private boolean descricaoInteligente;
	private boolean editavel = true;
	
	public UnidadeMedidaDTO() {
	}

	public UnidadeMedidaDTO(UnidadeMedida um) {
		this.id = um.getId();
		this.descricao = um.getDescricao();
		this.abreviatura = um.getAbreviatura();
		this.abreviaturaExportacao = um.getAbreviaturaExportacao();
		//this.codigoInteligente = um.isCodigoInteligente();
		//this.descricaoInteligente = um.isDescricaoInteligente();
		//this.editavel = um.isEditavel();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getAbreviaturaExportacao() {
		return abreviaturaExportacao;
	}

	public void setAbreviaturaExportacao(String abreviaturaExportacao) {
		this.abreviaturaExportacao = abreviaturaExportacao;
	}

	public boolean isCodigoInteligente() {
		return codigoInteligente;
	}

	public void setCodigoInteligente(boolean codigoInteligente) {
		this.codigoInteligente = codigoInteligente;
	}

	public boolean isDescricaoInteligente() {
		return descricaoInteligente;
	}

	public void setDescricaoInteligente(boolean descricaoInteligente) {
		this.descricaoInteligente = descricaoInteligente;
	}

	public boolean isEditavel() {
		return editavel;
	}

	public void setEditavel(boolean editavel) {
		this.editavel = editavel;
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
		UnidadeMedidaDTO other = (UnidadeMedidaDTO) obj;
		return Objects.equals(id, other.id);
	}	
}
