package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.erakis_ics.api.entity.Pessoa;
import com.erakis_ics.api.entity.Telefone;
import com.erakis_ics.api.entity.TipoTelefone;

public class TelefoneDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String ddd;
	private String numero;
	private String ramal;
	private TipoTelefone tipo;
	private Pessoa dono;
	
	public TelefoneDTO() {
	}

	public TelefoneDTO(Telefone tel) {
		
		this.id = tel.getId();
		this.ddd = tel.getDdd();
		this.numero = tel.getNumero();
		this.ramal = tel.getRamal();
		this.tipo = tel.getTipo();
		this.dono = tel.getDono();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
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
		TelefoneDTO other = (TelefoneDTO) obj;
		return Objects.equals(id, other.id);
	}
}
