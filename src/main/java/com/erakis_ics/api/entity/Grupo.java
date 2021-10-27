package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gru_id")
	private Long id;

	@Column(name = "gru_nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "gru_descricao", nullable = false, length = 200)
	private String descricao;

	@OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Permissao> listaPermissao = new HashSet<Permissao>(0);

	@ManyToMany(mappedBy = "grupos", fetch = FetchType.LAZY)
	private Set<Usuario> usuarios;

	public Grupo() {
	}

	public Grupo(Long id, String nome, String descricao, Set<Permissao> listaPermissao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.listaPermissao = listaPermissao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Permissao> getListaPermissao() {
		return listaPermissao;
	}

	public void setListaPermissao(Set<Permissao> listaPermissao) {
		this.listaPermissao = listaPermissao;
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
		Grupo other = (Grupo) obj;
		return Objects.equals(id, other.id);
	}
}
