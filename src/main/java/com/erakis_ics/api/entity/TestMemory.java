package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.http.HttpStatus;

@Entity
@Table(name = "tbl_test_memory")
public class TestMemory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private Long test_id;
	
	@Column(name = "number_http_response")
	private Integer number_http_response;

	@Column(name = "http_response")
	private HttpStatus http_response;
	
	@Column(name = "time_stamp")
	private Date time_stamp;

	@Column(name = "messages")
	private String messages;

	@Transient
	private List<PessoaJuridica> pessoas_juridicas;
	
	public TestMemory() {
	}

	
	public TestMemory(Long test_id, Integer number_http_response, HttpStatus http_response,
		Date time_stamp, String messages, List<PessoaJuridica> pessoas_juridicas) {
		this.test_id = test_id;
		this.number_http_response = number_http_response;
		this.http_response = http_response;
		this.time_stamp = time_stamp;
		this.messages = messages;
		this.pessoas_juridicas = pessoas_juridicas;
	}
	
	public TestMemory(Integer number_http_response, HttpStatus http_response,
		Date time_stamp,String messages, List<PessoaJuridica> pessoas_juridicas) {
		this.number_http_response = number_http_response;
		this.http_response = http_response;
		this.time_stamp = time_stamp;
		this.messages = messages;
		this.pessoas_juridicas = pessoas_juridicas;
	}


	public Date getTime_stamp() {
		return time_stamp;
	}


	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}


	public Long getTest_id() {
		return test_id;
	}

	public void setTest_id(Long test_id) {
		this.test_id = test_id;
	}

	public Integer getNumber_http_response() {
		return number_http_response;
	}

	public void setNumber_http_response(Integer number_http_response) {
		this.number_http_response = number_http_response;
	}

	public HttpStatus getHttp_response() {
		int response = 0;
		if (response == HttpStatus.OK.value()) {
			http_response = HttpStatus.OK;
		} else {
			http_response = HttpStatus.BAD_REQUEST;
		}
		return http_response;
	}

	public void setHttp_response(HttpStatus http_response) {
		this.http_response = http_response;
	}

	public String getMessages() {
		return "[ERROR]" + new RuntimeException();
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(test_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestMemory other = (TestMemory) obj;
		return Objects.equals(test_id, other.test_id);
	}
}
