package com.hotel.hotelproject.model;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//import lombok.Getter;
//import lombok.Setter;

@Entity
//@Getter
//@Setter
public class OrderDetails {
	@Id
	@GeneratedValue
	private int orderId;
	private int itemNo;
	private int orderBy;
	private int orderQuantity;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate=new Date();
	
	
	private boolean billstatus;
	
	

	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	public boolean isBillstatus() {
		return billstatus;
	}
	public void setBillstatus(boolean billstatus) {
		this.billstatus = billstatus;
	}
	
	
	
	
}
