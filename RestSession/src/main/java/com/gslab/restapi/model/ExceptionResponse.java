package com.gslab.restapi.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {

	private Integer errorCode;
	private Date timestamp;
	private String message;
	private String details;
	
	public ExceptionResponse() {
	}
}
