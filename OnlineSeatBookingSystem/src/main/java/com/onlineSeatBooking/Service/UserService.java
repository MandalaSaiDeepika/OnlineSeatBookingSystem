package com.onlineSeatBooking.Service;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineSeatBooking.Model.User;
import com.onlineSeatBooking.Repository.UserRepo;

@Service
	@Transactional
	public class UserService {
		
		@Autowired
		UserRepo repo;
		
		public User addUser(User u) {
			return repo.save(u);
		
		}
		
		public Optional<User> findById(int userId) {
			return repo.findById(userId);
		
		}
		public void updateUserById(User u) {
			repo.save(u);
			
		}

		public void updateUserByEmail(User user) {
			repo.save(user);
		}
		
		public Optional<User> findByEmail(String email) {
		
			return repo.findByEmail(email);
		  
		  }
}

