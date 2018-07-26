package com.niit;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class AdminController {

	
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/admin")
	public String adminPage(@ModelAttribute("category")Category category){
		return "adminadd";
	}
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public ModelAndView saveCategoryData(@ModelAttribute("category") Category category) {
		ModelAndView mv = new ModelAndView();
		categoryDAO.addCategory(category);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/proupdate",method=RequestMethod.GET)
	public String displayProductPage(Model m)
	{
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		
		return "proupdate";
	}
	
	@RequestMapping(value="/updateProduct/{productId}")
	public String updateCartItem(@PathVariable("productId") int productId,@RequestParam("price") int price,HttpSession session,Model m)
	{

		Product product=productDAO.getProduct(productId);
		product.setPrice(price);
		productDAO.updateProduct(product);

		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute(listProducts);
		return "proupdate";
		
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,HttpSession session,Model m)
	{
		
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute(listProducts);
		return "proupdate";
	}
}
