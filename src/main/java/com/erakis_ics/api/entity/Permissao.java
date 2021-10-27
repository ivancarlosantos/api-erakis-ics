package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perm_grupo_id")
	private Grupo grupo;

	@Id
	@Column(name = "perm_funcionalidade")
	private boolean selecionado;
	
	@Column(name = "perm_criar")
	private boolean criar;
	
	@Column(name = "perm_alterar")
	private boolean alterar;
	
	@Column(name = "perm_inativar")
	private boolean inativar;
	
	@Column(name = "perm_excluir")
	private boolean excluir;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public boolean isCriar() {
		return criar;
	}

	public void setCriar(boolean criar) {
		this.criar = criar;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}

	public boolean isInativar() {
		return inativar;
	}

	public void setInativar(boolean inativar) {
		this.inativar = inativar;
	}

	public boolean isExcluir() {
		return excluir;
	}

	public void setExcluir(boolean excluir) {
		this.excluir = excluir;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(grupo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permissao other = (Permissao) obj;
		return Objects.equals(grupo, other.grupo);
	}
	
}
