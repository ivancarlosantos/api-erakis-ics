package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*  
 * @author by: icarlos 
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	private Long usr_id;

	@Column(name = "usr_nome", nullable = false, length = 20, unique = true)
	private String nome;

	@Column(name = "usr_senha", nullable = false, length = 255)
	private String senha;

	@Column(name = "usr_salt", nullable = false, length = 255)
	private String salt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "usr_ultimo_login")
	private Date ultimoLogin;

	@Column(name = "usr_administrador")
	private boolean administrador;

	@Column(name = "usr_bloqueado")
	private boolean bloqueado;

	@Column(name = "usr_login_bloqueado")
	private boolean loginBloqueado;

	@Column(name = "usr_cancelar_bloqueado")
	private Boolean cancelarBloqueado;

	@Column(name = "usr_editar_bloqueado")
	private Boolean editarBloqueado;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usr_pessoa_fisica_id", unique = true)
	private PessoaFisica pessoaFisica;

	public Usuario() {
	}

	
	public Usuario(Long usr_id, String nome, String senha, String salt, Date ultimoLogin,
			boolean administrador, boolean bloqueado, boolean loginBloqueado, Boolean cancelarBloqueado,
			Boolean editarBloqueado, PessoaFisica pessoaFisica) {
		super();
		this.usr_id = usr_id;
		this.nome = nome;
		this.senha = senha;
		this.salt = salt;
		this.ultimoLogin = ultimoLogin;
		this.administrador = administrador;
		this.bloqueado = bloqueado;
		this.loginBloqueado = loginBloqueado;
		this.cancelarBloqueado = cancelarBloqueado;
		this.editarBloqueado = editarBloqueado;
		this.pessoaFisica = pessoaFisica;
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
	}

	public Date getUltimoLogin() {
		return ultimoLogin;
	}

	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(usr_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usr_id, other.usr_id);
	}
}
