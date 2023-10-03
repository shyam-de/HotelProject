package com.hotel.hotelproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InvalidUserException extends Exception {
	private static final long  serialVersionUID =1L;
	public InvalidUserException(String msg) {
		super(msg);
	}

}
