package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.Date;

import com.erakis_ics.api.entity.PessoaFisica;
import com.erakis_ics.api.entity.Sexo;

public class PessoaFisicaDTO implements Serializable{

	private static final long serialVersionUID = 3L;
	private Long psfis_id;
	private String nome;
	private Sexo sexo;
	private Date dataNascimento;
	private String cpf;
	private String rg;
	private String orgaoEmissorRg;
	
	public PessoaFisicaDTO() {
	}

	public PessoaFisicaDTO(PessoaFisica pf) {
		this.psfis_id = pf.getId();
		this.nome = pf.getNome();
		this.sexo = pf.getSexo();
		this.dataNascimento = pf.getDataNascimento();
		this.cpf = pf.getCpf();
		this.rg = pf.getRg();
		this.orgaoEmissorRg = pf.getOrgaoEmissorRg();
	}

	public String getOrgaoEmissorRg() {
		return orgaoEmissorRg;
	}

	public void setOrgaoEmissorRg(String orgaoEmissorRg) {
		this.orgaoEmissorRg = orgaoEmissorRg;
	}

	public Long getPsfis_id() {
		return psfis_id;
	}

	public void setPsfis_id(Long psfis_id) {
		this.psfis_id = psfis_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
}
