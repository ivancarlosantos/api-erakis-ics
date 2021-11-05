package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.Date;

import com.erakis_ics.api.entity.PessoaFisica;
import com.erakis_ics.api.entity.Usuario;

public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long usr_id;
	private String nome;
	//private String senha;
	//private String salt;
	private Date ultimoLogin;
	//private Set<Grupo> grupos = new HashSet<Grupo>(0);
	private boolean administrador;
	private boolean bloqueado;
	private boolean loginBloqueado;
	private Boolean cancelarBloqueado;
	private Boolean editarBloqueado;
	private PessoaFisica pessoaFisica;

	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Usuario usr) {
		
		this.usr_id = usr.getUsr_id();
		this.nome = usr.getNome();
		//this.senha = usr.getSenha();
		//this.salt = usr.getSalt();
		this.ultimoLogin = usr.getUltimoLogin();
		//this.grupos = usr.getGrupos();
		this.administrador = usr.isAdministrador();
		this.bloqueado = usr.isBloqueado();
		this.loginBloqueado = usr.isLoginBloqueado();
		this.cancelarBloqueado = usr.getCancelarBloqueado();
		this.editarBloqueado = usr.getEditarBloqueado();
		//this.pessoaFisica = usr.getPessoaFisica();
	}

	public Long getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(Long usr_id) {
		this.usr_id = usr_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	} 

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	} */

	public Date getUltimoLogin() {
		return ultimoLogin;
	}

	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

	/*
	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	} */

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public boolean isLoginBloqueado() {
		return loginBloqueado;
	}

	public void setLoginBloqueado(boolean loginBloqueado) {
		this.loginBloqueado = loginBloqueado;
	}

	public Boolean getCancelarBloqueado() {
		return cancelarBloqueado;
	}

	public void setCancelarBloqueado(Boolean cancelarBloqueado) {
		this.cancelarBloqueado = cancelarBloqueado;
	}

	public Boolean getEditarBloqueado() {
		return editarBloqueado;
	}

	public void setEditarBloqueado(Boolean editarBloqueado) {
		this.editarBloqueado = editarBloqueado;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	 
}
