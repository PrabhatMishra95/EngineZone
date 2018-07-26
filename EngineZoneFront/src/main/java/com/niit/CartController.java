package com.niit;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.Product;

@Controller
public class CartController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/showCart")
	public String showCart(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartDAO.listCartItems(username);
		
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		session.setAttribute("CartItems",listCartItems.size());
		
		return "Cart";
	}
	
	@RequestMapping(value="/addToCart/{productId}")
	public String addToCart(@PathVariable("productId") int productId,@RequestParam("quantity")int quantity,HttpSession session,Model m)
	{
		
		CartItem cartItem=new CartItem();
		Product product=productDAO.getProduct(productId);
		String username=(String)session.getAttribute("username");
		
		cartItem.setProductId(productId);
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setPrice(product.getPrice());
		cartItem.setStatus("NP");
		cartItem.setUsername(username);
		
		cartDAO.addToCart(cartItem);
		
		List<CartItem> listCartItems=cartDAO.listCartItems(username);
		
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		session.setAttribute("CartItems",listCartItems.size());
		
		return "Cart";
	}
	
	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
	{
		
		CartItem cartItem=cartDAO.getCartItem(cartItemId);
		cartDAO.deleteFromCart(cartItem);
		
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartDAO.listCartItems(username);
		
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		session.setAttribute("CartItems",listCartItems.size());
		
		return "Cart";
	}
	
	@RequestMapping(value="/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId") int cartItemId,@RequestParam("qty") int quantity,Model m,HttpSession session)
	{

		CartItem cartItem=cartDAO.getCartItem(cartItemId);
		cartItem.setQuantity(quantity);
		cartDAO.updateCart(cartItem);
		
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartDAO.listCartItems(username);
		
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		session.setAttribute("CartItems",listCartItems.size());
		
		return "Cart";
		
	}
	public int calculateTotalCost(List<CartItem> cartItems)
	{
		int totalCost=0;
		int count=0;
		
		while(count<cartItems.size())
		{
			totalCost=totalCost+(cartItems.get(count).getPrice()*cartItems.get(count).getQuantity());
			count++;
		}
		
		return totalCost;
	}
}
