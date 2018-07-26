package com.niit.EngineZoneBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;

public class CartDAOTest 
{

	static CartDAO cartDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Test
	public void addCartTest()
	{
		CartItem cartItem=new CartItem();
		
		cartItem.setCartItemId(1);
		cartItem.setProductId(12);
		cartItem.setProductName("Engine Cylinder");
		cartItem.setQuantity(10);
		cartItem.setStatus("NP");
		cartItem.setUsername("Pr");
		cartItem.setPrice(7000);
		
		assertTrue("Creating CartItem",cartDAO.addToCart(cartItem));
	}
}
