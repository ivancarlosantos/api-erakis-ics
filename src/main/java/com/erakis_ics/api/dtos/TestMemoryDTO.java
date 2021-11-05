package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;

import com.erakis_ics.api.entity.TestMemory;

public class TestMemoryDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long test_id;
	
	private HttpStatus http_response;
	
	private Integer number_http_response;
	
	private Date time_stamp;

	private String messages;
	
	private List<PessoaJuridicaDTO> pessoas_juridicas;
	
	public TestMemoryDTO() {
	}

	public TestMemoryDTO(TestMemory t) {
		this.test_id = t.getTest_id();
		this.number_http_response = t.getNumber_http_response();
		this.http_response = t.getHttp_response();
		this.time_stamp = t.getTime_stamp();
		this.messages = t.getMessages();
	}

	/*public Long getTest_id() {
		return test_id;
	}

	public void setTest_id(Long test_id) {
		this.test_id = test_id;
	} */

	
	public HttpStatus getHttp_response() {
		return http_response;
	}

	public Integer getNumber_http_response() {
		return number_http_response;
	}

	public void setNumber_http_response(Integer number_http_response) {
		this.number_http_response = number_http_response;
	}

	public void setHttp_response(HttpStatus http_response) {
		this.http_response = http_response;
	}
	
	public Date getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}
	

	public List<PessoaJuridicaDTO> getpessoas_juridicas() {
		return pessoas_juridicas;
	}

	public void setPessoas_juridicas(List<PessoaJuridicaDTO> pessoas_juridicas) {
		this.pessoas_juridicas = pessoas_juridicas;
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
		TestMemoryDTO other = (TestMemoryDTO) obj;
		return Objects.equals(test_id, other.test_id);
	}
}
