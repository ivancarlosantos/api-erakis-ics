package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "psfis_id")
	private Long psfis_id;

	@Column(name = "psfis_nome", nullable = false, length = 200)
	private String nome;

	@Column(name = "psfis_sexo", nullable = false)
	private Sexo sexo;

	@Temporal(TemporalType.DATE)
	@Column(name = "psfis_data_nascimento")
	private Date dataNascimento;

	@Column(name = "psfis_estado_civil")
	private EstadoCivil estadoCivil;

	@Column(name = "psfis_cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "psfis_rg", nullable = false, length = 20)
	private String rg;

	@Column(name = "psfis_orgao_emissor_rg", nullable = false, length = 20)
	private String orgaoEmissorRg;

	@Column(name = "psfis_orgao_emissor_cnh", length = 20)
	private String orgaoEmissorCnh;

	@Column(name = "psfis_observacao", columnDefinition = "TEXT")
	private String observacao;

	@Column(name = "psfis_cnh", length = 11)
	private String cnh;

	@Column(name = "psfis_profissao", length = 50)
	private String profissao;

	public PessoaFisica() {
	}

	public PessoaFisica(Long id, String nome, Sexo sexo, Date dataNascimento, EstadoCivil estadoCivil, String cpf,
			String rg, String orgaoEmissorRg, String orgaoEmissorCnh, String observacao, String cnh, String profissao) {

		this.psfis_id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil;
		this.cpf = cpf;
		this.rg = rg;
		this.orgaoEmissorRg = orgaoEmissorRg;
		this.orgaoEmissorCnh = orgaoEmissorCnh;
		this.observacao = observacao;
		this.cnh = cnh;
		this.profissao = profissao;
	}

	public Long getId() {
		return psfis_id;
	}

	public void setId(Long id) {
		this.psfis_id = id;
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

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
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

	public String getOrgaoEmissorRg() {
		return orgaoEmissorRg;
	}

	public void setOrgaoEmissorRg(String orgaoEmissorRg) {
		this.orgaoEmissorRg = orgaoEmissorRg;
	}

	public String getOrgaoEmissorCnh() {
		return orgaoEmissorCnh;
	}

	public void setOrgaoEmissorCnh(String orgaoEmissorCnh) {
		this.orgaoEmissorCnh = orgaoEmissorCnh;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(psfis_id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(psfis_id, other.psfis_id);
	}
}
