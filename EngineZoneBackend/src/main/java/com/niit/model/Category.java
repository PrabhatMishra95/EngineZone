package com.niit.model;

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
public class Category 
{
	@Id
	
	private int categoryId;
	
	private String categoryName;
	private String categoryDesc;
	
	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}
	public String getCategoryName() 
	{
		return categoryName;
	}
	public void setCategoryName(String categoryName) 
	{
		this.categoryName = categoryName;
	}
	public String getCategoryDesc() 
	{
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) 
	{
		this.categoryDesc = categoryDesc;
	}
	
	
	
}
