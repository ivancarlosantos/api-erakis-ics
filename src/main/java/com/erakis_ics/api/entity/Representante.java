package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "representante")
public class Representante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rpst_id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rpst_pessoa_id", unique = true)
	private Pessoa pessoa;

	@JoinTable(name = "representante__tabela_preco", joinColumns = {
			@JoinColumn(name = "rptpr_rpst_id") }, inverseJoinColumns = { @JoinColumn(name = "rptpr_tbprc_id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH })
	@OrderColumn(name = "rptpr_ordem")
	private List<TabelaPreco> tabelasPreco = new ArrayList<TabelaPreco>();

	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "representante", orphanRemoval = true)
	//private List<Cliente> clientes = new ArrayList<Cliente>();

	@Column(name = "rpst_ativo")
	private Boolean ativo = true;

	@Column(name = "rpst_email_nota_fiscal")
	private String emailNotaFiscal;

	@Column(name = "rpst_observacao", columnDefinition = "TEXT")
	private String observacao;

	@Column(name = "rpst_codigo_numerico")
	private Long codigoNumerico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<TabelaPreco> getTabelasPreco() {
		return tabelasPreco;
	}

	public void setTabelasPreco(List<TabelaPreco> tabelasPreco) {
		this.tabelasPreco = tabelasPreco;
	}

	/*
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	} */

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getEmailNotaFiscal() {
		return emailNotaFiscal;
	}

	public void setEmailNotaFiscal(String emailNotaFiscal) {
		this.emailNotaFiscal = emailNotaFiscal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
		Representante other = (Representante) obj;
		return Objects.equals(id, other.id);
	}
}
