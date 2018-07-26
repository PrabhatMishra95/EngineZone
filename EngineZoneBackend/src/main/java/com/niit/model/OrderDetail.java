package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderDetail 
{
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "h2_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int orderId;
	
	private int purchaseValue;
	private Date orderDate;
	private String username;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPurchaseValue() {
		return purchaseValue;
	}
	public void setPurchaseValue(int purchaseValue) {
		this.purchaseValue = purchaseValue;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
		
}
