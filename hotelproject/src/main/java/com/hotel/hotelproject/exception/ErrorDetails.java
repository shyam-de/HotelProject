package com.hotel.hotelproject.exception;

import java.util.Date;

public class ErrorDetails {
	private String errorMessag;
	private Date timeStamp;
	private String detail;
	public ErrorDetails() {
		
	}
	public ErrorDetails( Date timeStamp,String errorMessag, String detail) {
		super();
		this.errorMessag = errorMessag;
		this.timeStamp = timeStamp;
		this.detail = detail;
	}
	public String getErrorMessag() {
		return errorMessag;
	}
	public void setErrorMessag(String errorMessag) {
		this.errorMessag = errorMessag;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

}
