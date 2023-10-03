package com.hotel.hotelproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotelproject.model.AdminDetails;

public interface AdminRepository extends JpaRepository<AdminDetails, Integer> {

	public AdminDetails findByAdminNameAndPassword(String adminName, String password);
	

}
