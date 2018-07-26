package com.niit.EngineZoneBackend;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductDAOTest 
{
	
static ProductDAO productDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(12);
		product.setProductName("Piston");
		product.setProdDesc("Piston description");
		product.setPrice(12000);
		product.setCategoryId(10);
		product.setStock(12);
		product.setSupplierId(2);
		
		assertTrue("Adding Category",productDAO.addProduct(product));
	}
	
	
}
