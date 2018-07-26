package com.niit.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class UserDetail {
	@Id
	@Size(min = 3, message = "Enter at least 3 characters")
	@Pattern(regexp="[^!-@]*",message="User name should not have any numbers or special characters")
	private String username;
	@Size(min = 3, message = "Enter at least 3 characters")
	private String password;
	
	private String role;
	private boolean enabled;
	@Size(min = 3, message = "Enter at least 3 characters")
	@Pattern(regexp="[^0-9]*",message="Customer name should not have any numbers")
	private String customerName;
	@Pattern(regexp="[^A-Z]*",message="Mobile number should not have any alphabet")
	private String mobileNo;
	@Email
	private String emailId;
	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
