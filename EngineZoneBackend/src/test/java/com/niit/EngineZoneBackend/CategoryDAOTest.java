package com.niit.EngineZoneBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTest 
{
	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryId(10);
		category.setCategoryName("Bearing");
		category.setCategoryDesc("Bearing description");
		
		assertTrue("Adding Category",categoryDAO.addCategory(category));
	}
	
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(10);
		category.setCategoryName("updated Bearing");
		assertTrue("Updating",categoryDAO.updateCategory(category));
	}
	
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(10);
		assertTrue("Deleting:",categoryDAO.deleteCategory(category));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.getCategories();
		assertNotNull("Retrieving:",listCategories);
	}
	
}
