package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Transient;

import org.springframework.http.HttpStatus;

public class TestMemory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "number_http_response")
	private Integer number_http_response;

	@Column(name = "http_response")
	private HttpStatus http_response;

	@Column(name = "messages")
	private String messages;
	
	@Column(name = "time_stamp")
	private Date time_stamp;

	@Transient
	private List<PessoaJuridica> pessoas_juridicas;

	public TestMemory() {
	}

	public TestMemory(Integer number_http_response, HttpStatus http_response, String messages, Date time_stamp,
			List<PessoaJuridica> pessoas_juridicas) {
		this.number_http_response = number_http_response;
		this.http_response = http_response;
		this.messages = messages;
		this.time_stamp = time_stamp;
		this.pessoas_juridicas = pessoas_juridicas;
	}

	public Integer getNumber_http_response() {
		return number_http_response;
	}

	public void setNumber_http_response(Integer number_http_response) {
		this.number_http_response = number_http_response;
	}

	public HttpStatus getHttp_response() {
		return http_response;
	}

	public void setHttp_response(HttpStatus http_response) {
		this.http_response = http_response;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public Date getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}
}
