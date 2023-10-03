package com.hotel.hotelproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotelproject.model.ItemDetails;

public interface ItemRepository extends JpaRepository<ItemDetails, Integer>{

	 ItemDetails findByItemName(String itemName);

}
