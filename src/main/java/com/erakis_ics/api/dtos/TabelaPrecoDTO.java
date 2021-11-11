package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.erakis_ics.api.entity.Cliente;
import com.erakis_ics.api.entity.PrecoComercializavel;
import com.erakis_ics.api.entity.Representante;
import com.erakis_ics.api.entity.TabelaPreco;

public class TabelaPrecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private Date dataInicial;
	private Date dataFinal;
	private boolean padrao;
	private Boolean padraoServico;
	private List<PrecoComercializavel> precos;
	private List<Cliente> clientes;
	private List<Representante> representantes;

	public TabelaPrecoDTO() {
	}

	public TabelaPrecoDTO(TabelaPreco tp) {
		this.id = tp.getId();
		this.titulo = tp.getTitulo();
		this.dataInicial = tp.getDataInicial();
		this.dataFinal = tp.getDataFinal();
		this.padraoServico = tp.getPadraoServico();
		this.precos = tp.getPrecos();
		this.clientes = tp.getClientes();
		this.representantes = tp.getRepresentantes();
	}

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

	public List<Representante> getRepresentantes() {
		return representantes;
	}

	public void setRepresentantes(List<Representante> representantes) {
		this.representantes = representantes;
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
		TabelaPrecoDTO other = (TabelaPrecoDTO) obj;
		return Objects.equals(id, other.id);
	}
}
