package com.erakis_ics.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*  
 * @author by: icarlos 
 */

@Entity
@Table(name = "Login")
public class Login implements Serializable {

	private static final long serialVersionUID = -1026105231718280474L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_name", nullable = false, length = 50)
	private String userName;

	@Column(name = "login", nullable = false, length = 50)
	private String login;

	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "login_password", nullable = false, length = 15)
	private String loginPassword;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}
