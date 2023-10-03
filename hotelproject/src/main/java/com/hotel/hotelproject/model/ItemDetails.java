package com.hotel.hotelproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import lombok.Getter;
//import lombok.Setter;

@Entity
//@Getter
//@Setter
public class ItemDetails {
	
	@Id
	@GeneratedValue
	private int itemId;
	private String itemName;
	private double price;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
