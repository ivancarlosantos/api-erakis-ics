package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.erakis_ics.api.entity.Cliente;
import com.erakis_ics.api.entity.Pessoa;
import com.erakis_ics.api.entity.Representante;
import com.erakis_ics.api.entity.TabelaPreco;

public class RepresentanteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Pessoa pessoa;
	private List<TabelaPreco> tabelasPreco;
	private List<Cliente> clientes;
	private Boolean ativo = true;
	private String emailNotaFiscal;
	private String observacao;
	private Long codigoNumerico;

	public RepresentanteDTO() {
	}

	public RepresentanteDTO(Representante rpst) {
		this.id = rpst.getId();
		//this.pessoa = rpst.getPessoa();
		this.tabelasPreco = rpst.getTabelasPreco();
		//this.clientes = rpst.getClientes();
		this.ativo = rpst.getAtivo();
		this.emailNotaFiscal = rpst.getEmailNotaFiscal();
		this.observacao = rpst.getObservacao();
		this.codigoNumerico = rpst.getCodigoNumerico();
	}

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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

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
		RepresentanteDTO other = (RepresentanteDTO) obj;
		return Objects.equals(id, other.id);
	}	
}
