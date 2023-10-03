package com.hotel.hotelproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotelproject.exception.InvalidUserException;
import com.hotel.hotelproject.exception.ItemNotFoundException;
import com.hotel.hotelproject.model.AdminDetails;
import com.hotel.hotelproject.model.ItemDetails;
import com.hotel.hotelproject.model.OrderDetails;
import com.hotel.hotelproject.model.UserDetails;
import com.hotel.hotelproject.repository.AdminRepository;
import com.hotel.hotelproject.repository.ItemRepository;
import com.hotel.hotelproject.repository.OrderRepository;
import com.hotel.hotelproject.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ItemRepository itemRepo;
	boolean valid = true;
	
	
	@PostMapping("/newadmin")
	public ResponseEntity<String> createAdmin(@RequestBody AdminDetails admin){
		adminRepo.save(admin);
		return ResponseEntity.ok("New Admin is Created....");
	}
	@PostMapping("/adminlogin")
	public ResponseEntity<String> adminLogin(@RequestBody AdminDetails admin) {
		AdminDetails admind= adminRepo.findByAdminNameAndPassword(admin.getAdminName() , admin.getPassword());
		return ResponseEntity.ok("Valid User");
	}
	
	@GetMapping("/userorder/{id}")
	public OrderDetails userOrder(@PathVariable(value="id") int uid) {
		OrderDetails od = orderRepo.findAllByOrderBy(uid);
		return od;
	}
	
	// CRUD operation By Admin on Item
	@PostMapping("/additem")
	public ResponseEntity<String> addItem(@RequestBody ItemDetails item){
		itemRepo.save(item);
		return ResponseEntity.ok("Item added successfully In Food Menu..");
	}
	
	@PutMapping("/updateitem")
	public ResponseEntity<String> updateItem(@RequestBody ItemDetails item) throws ItemNotFoundException{
	    ItemDetails items=itemRepo.findByItemName(item.getItemName());
			itemRepo.save(items);
	     
		return ResponseEntity.ok("Item Updated successfully ..");
	}
	@DeleteMapping("/deleteitem/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable(value="id") int delId) throws ItemNotFoundException{
		Optional<ItemDetails> item= itemRepo.findById(delId);
		if(item.isPresent()) {
			itemRepo.deleteById(delId);
		}
		else throw new ItemNotFoundException("Item Not present in food manu ...");
		
		return ResponseEntity.ok("Item deleted from Food Manu");
	}
	
	// CRUD operation By Admin on User
	
	@PostMapping("/adduser")
	public ResponseEntity<String> createUser(@RequestBody List<UserDetails> user){
		userRepo.saveAll(user);
		return ResponseEntity.ok("New User added successfully..");
	}
	
	@GetMapping("/getalluser")
	
	public UserDetails getAllUser(){
		List<UserDetails> users= userRepo.findAll();
		return  (UserDetails) users;
	}
	
	@GetMapping("/getuser/{id}")
	
	public Optional<UserDetails> getUserById(@PathVariable(value="id") int uid){
		Optional<UserDetails> user = userRepo.findById(uid);
		return user;
	}
	
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> removeUser(@PathVariable(value="id") int delId)throws InvalidUserException{
		UserDetails u= userRepo.findById(delId).orElseThrow(()->new InvalidUserException("User Not present .."));
			userRepo.deleteById(delId);
	
		
		return ResponseEntity.ok("User Removed ...");
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable(value ="id") int uid ,@RequestBody UserDetails user) throws InvalidUserException{
	     
			UserDetails userupdate = userRepo.findById(uid).orElseThrow(()-> new InvalidUserException("User Not present") );
			userRepo.save(user);
		
	     
		return ResponseEntity.ok("User Detail Updated successfully ..");
	}
	
}
