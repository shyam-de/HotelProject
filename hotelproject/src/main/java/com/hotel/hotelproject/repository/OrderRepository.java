package com.hotel.hotelproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotelproject.model.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

	OrderDetails findAllByOrderBy(int uid);

}
