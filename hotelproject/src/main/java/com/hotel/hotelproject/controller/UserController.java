package com.hotel.hotelproject.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotelproject.exception.ItemNotFoundException;
import com.hotel.hotelproject.model.ItemDetails;
import com.hotel.hotelproject.model.OrderDetails;
import com.hotel.hotelproject.model.UserDetails;
import com.hotel.hotelproject.repository.ItemRepository;
import com.hotel.hotelproject.repository.OrderRepository;
import com.hotel.hotelproject.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	OrderRepository  orderRepo;
	
	@PostMapping("/newuser")
	public ResponseEntity<String> createUser(@RequestBody UserDetails user){
		userRepo.save(user);
		return ResponseEntity.ok("New User is Created make your 1st order....");
	}
	@PostMapping("/userlogin")
	public ResponseEntity<String> userLogin(@RequestBody UserDetails user) {
		UserDetails userData= userRepo.findByUserNameAndUserPassword(user.getUserName() , user.getUserPassword());
		return ResponseEntity.ok("Valid User Make Your first order ....");
	}
	
	@GetMapping("/viewallitem")
	public List<ItemDetails> seeAllItems() {
		return itemRepo.findAll();
				
	}
	
	@GetMapping("/myorder/{id}")
	public OrderDetails myOrder(@PathVariable(value="id") int uid) {
		List<OrderDetails> od= (List<OrderDetails>) orderRepo.findAllByOrderBy(uid);
		
		List<OrderDetails> yourOrder = new ArrayList<OrderDetails>();
		for(OrderDetails o:od) {
			OrderDetails od2 = new OrderDetails();
			od2.setOrderId(((OrderDetails) o).getOrderId());
			od2.setItemNo(((OrderDetails) o).getItemNo());
			od2.setOrderQuantity(((OrderDetails) o).getOrderQuantity());
			od2.setOrderDate(((OrderDetails) o).getOrderDate());
			od2.setBillstatus(((OrderDetails) o).isBillstatus());
			yourOrder.add(od2);
		}
		return (OrderDetails) yourOrder;
		
	}
	
	@PostMapping("/makeoder")
	public ResponseEntity<String> makeOrder(@RequestBody List<OrderDetails> orderList){
		orderRepo.saveAll(orderList);
		return ResponseEntity.ok("Order Placed....");
	}
	
	@PostMapping("/makeorderbill/{id}")
	public ResponseEntity<String> makeOrderBill(@PathVariable(value="id") int uid) throws ItemNotFoundException{
		List<OrderDetails> ordered = (List<OrderDetails>) orderRepo.findAllByOrderBy(uid);
	
		int totalBill = 0;
		for(OrderDetails ord:ordered ) {
			ItemDetails item = itemRepo.findById(ord.getItemNo()).orElseThrow(()->new ItemNotFoundException("You have ordered nothing")) ;
			int itemPrice =  (int) item.getPrice();
			totalBill = ord.getOrderQuantity()*itemPrice;
		}	
		return ResponseEntity.ok("Your Total Payable Bill Is"+totalBill);
	}
	

}
