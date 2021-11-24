package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.erakis_ics.api.entity.Endereco;
import com.erakis_ics.api.entity.TipoEndereco;

public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	//private Pessoa dono;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String complemento;
	//private Municipio municipio;
	private TipoEndereco tipo;

	public EnderecoDTO() {
	}

	public EnderecoDTO(Endereco end) {
		this.id = end.getId();
		//this.dono = end.getDono();
		this.logradouro = end.getLogradouro();
		this.numero = end.getNumero();
		this.bairro = end.getBairro();
		this.cep = end.getCep();
		this.complemento = end.getComplemento();
		//this.municipio = end.getMunicipio();
		this.tipo = end.getTipo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

/*	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	} */

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/*public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}*/

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
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
		EnderecoDTO other = (EnderecoDTO) obj;
		return Objects.equals(id, other.id);
	}
}
