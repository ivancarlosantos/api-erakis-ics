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
@Table(name = "unidade_medida")
public class UnidadeMedida implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "undmd_id")
	private Long id;
	
	@Column(name = "undmd_descricao", unique = true)
	private String descricao;
	
	@Column(name = "undmd_abreviatura", unique = true)
	private String abreviatura;
	
	@Column(name = "undmd_abreviatura_exportacao", unique = true)
	private String abreviaturaExportacao;	
	
	@Column(name = "undmd_codigo_inteligente")
	private boolean codigoInteligente;
	
	@Column(name = "undmd_descricao_inteligente")
	private boolean descricaoInteligente;
	
	@Column(name = "undmd_editavel")
	private boolean editavel = true;

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
		UnidadeMedida other = (UnidadeMedida) obj;
		return Objects.equals(id, other.id);
	}
}
