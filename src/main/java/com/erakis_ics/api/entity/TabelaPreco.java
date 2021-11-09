package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//@Entity
//@Table(name = "tabela_preco")
public class TabelaPreco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbprc_id")
	private Long id;
	
	@Column(name = "tbprc_titulo")
	private String titulo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "tbprc_data_inicial")
	private Date dataInicial;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "tbprc_data_final")
	private Date dataFinal;
	
	@Column(name = "tbprc_padrao")
	private boolean padrao;
	
	@Column(name = "tbprc_padrao_servico")
	private Boolean padraoServico;
	
	@OrderBy("comercializavel")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "tabelaPreco",orphanRemoval = true)
	private List<PrecoComercializavel> precos = new ArrayList<PrecoComercializavel>();
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "tabelasPreco",cascade = CascadeType.ALL)
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "tabelasPreco", cascade = CascadeType.ALL)
	private Set<Representante> representantes = new HashSet<Representante>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public boolean isPadrao() {
		return padrao;
	}

	public void setPadrao(boolean padrao) {
		this.padrao = padrao;
	}

	public Boolean getPadraoServico() {
		return padraoServico;
	}

	public void setPadraoServico(Boolean padraoServico) {
		this.padraoServico = padraoServico;
	}

	public List<PrecoComercializavel> getPrecos() {
		return precos;
	}

	public void setPrecos(List<PrecoComercializavel> precos) {
		this.precos = precos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Set<Representante> getRepresentantes() {
		return representantes;
	}

	public void setRepresentantes(Set<Representante> representantes) {
		this.representantes = representantes;
	}
}
