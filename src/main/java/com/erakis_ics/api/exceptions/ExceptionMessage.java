package com.erakis_ics.api.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionMessage {

	private HttpStatus errorStatus;
	private Date timeStamp;
	private String message;

	public ExceptionMessage() {
	}

	public ExceptionMessage(HttpStatus badRequest, Date errorTime, String message) {
		this.errorStatus = badRequest;
		this.timeStamp = errorTime;
		this.message = message;
	}

	public ExceptionMessage(Date timeStamp, String message) {
		this.timeStamp = timeStamp;
		this.message = message;
	}

	public HttpStatus getStatusCode() {
		return errorStatus;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.errorStatus = statusCode;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
