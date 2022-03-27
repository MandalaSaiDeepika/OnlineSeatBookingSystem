package com.onlineSeatBooking.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
		@Table(name = "users")
		public class User implements Serializable {
	    	
	    	private static final long serialVersionUID = 1L;
	    	@Id
	    	@GeneratedValue(strategy=GenerationType.AUTO)
	    	private int userId;
	    	
	    	@NotEmpty
	    	@Size(min = 2, message = "userName must have atleast 2 characters")
	    	private String userName;
	    	
	    	@NotNull(message = "password must not be empty")
	    	private String password;
	    	
	    	@NotNull(message = "email must not be empty")
	    	@Email(message = "email should be in valid format")
	    	private String email;
	    	
	    	public User() {
				super();
				
			}

			public User(String userName,String password,String email) {
				super();
				this.userName = userName;
				this.password = password;
				this.email = email;
			}

			public int getUserId() {
				return userId;
			}

	        public void setUserId(int userId) {
				this.userId = userId;
			}
	        
	        public String getUserName() {
				return userName;
			}

	        public void setUserName(String userName) {
				this.userName = userName;
	        }
	        
	        public String getPassword() {
				return password;
			}

	        public void setPassword(String password) {
				this.password = password;
			}

	        public String getEmail() {
				return email;
			}

	        public void setEmail(String email) {
				this.email = email;
			}
	        
	        public static long getSerialversionuid() {
				return serialVersionUID;
			}

			@Override
			public String toString() {
				return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
						+ "]";
			}

}
