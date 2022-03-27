package com.onlineSeatBooking.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineSeatBooking.Exception.ResourceNotFoundException;
import com.onlineSeatBooking.Model.User;
import com.onlineSeatBooking.Service.UserService;


@RestController
	@RequestMapping("/User")
	public class UserController {
		
		@Autowired
		private UserService userservice;
		
		@PostMapping("/add")
		public ResponseEntity<String> addUser(@Validated @RequestBody User u){
			
			User user = userservice.addUser(u);
			return new ResponseEntity<String>("Record Inserted Successfully",HttpStatus.OK);
		}
		
		@PutMapping("/UpdateUserById")
		public ResponseEntity<String> updateUserById(@Validated @RequestBody User u){
			
	         String status = null;
			Optional<User> obj = userservice.findById(u.getUserId());
			
			if(obj.isPresent()) {
				userservice.updateUserById(u);
				status = "User Details Updated Successfully";
				
			}else {
				//status = "Invalid Id";
				throw new ResourceNotFoundException("Please Provide a Valid Id");
			}
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}

		@PostMapping("/ResetPassword")
		public ResponseEntity<String> updateUserByEmail(@RequestBody User u){
	  
			String status = null;
			Optional<User> obj = userservice.findByEmail(u.getEmail());
			
			//obj.get().setPassword(u.getPassword());
			if(obj.isPresent()) {
				
				userservice.updateUserByEmail(u);
				status ="Password changed Successfully";
	  
	  }else { 
		  //status="Invalid Email"; 
		  throw new ResourceNotFoundException("Please Provide a Valid Email");
		  } 
			return new ResponseEntity<String>(status,HttpStatus.OK); 
			
		}
	  
	  }


