package com.hotel.hotelproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends Exception {
	private static final long  serialVersionUID =2L;
	
	public ItemNotFoundException(String msg) {
		
		super(msg);
	}
}
