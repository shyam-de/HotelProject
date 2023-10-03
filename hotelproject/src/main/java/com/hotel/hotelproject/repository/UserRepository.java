package com.hotel.hotelproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotelproject.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	UserDetails findByUserNameAndUserPassword(String userName, String userPassword);

}
