package com.onlineSeatBooking.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlineSeatBooking.Model.User;

@Repository
	public interface UserRepo extends JpaRepository<User ,Integer>{

	public Optional<User> findByEmail(@Param("email")String emailId);
	

}

