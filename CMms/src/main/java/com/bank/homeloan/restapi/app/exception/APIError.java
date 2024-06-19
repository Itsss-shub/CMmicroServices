package com.bank.homeloan.restapi.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIError {
	private Integer statuscode;
	private String message;
	private Date date;
	private String path;
	private HttpStatus httpmsg;

}
