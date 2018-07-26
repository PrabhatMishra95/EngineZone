package com.niit;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDAO;
import com.niit.model.CartItem;
import com.niit.model.OrderDetail;
import com.niit.model.UserDetail;

@Controller
public class PaymentController 
{
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;

	@RequestMapping(value="/orderConfirm")
	public String showOrderConfirm(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartDAO.listCartItems(username);
		
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		session.setAttribute("CartItems",listCartItems.size());
		
		return "/OrderConfirm";
	}

	@Autowired
	UserDetail userdetail;
	@RequestMapping(value="/paymentConfirmation")
	public String paymentConfirm(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartDAO.listCartItems(username);
		
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		m.addAttribute("address",userdetail.getAddress());
		session.setAttribute("CartItems",0);
		
		if(orderDAO.updateCartItemStatus(username))
		{
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setPurchaseValue(this.calculateTotalCost(listCartItems));
		orderDetail.setUsername(username);
		orderDetail.setOrderDate(new java.util.Date());
		orderDAO.receiptGenerate(orderDetail);
		
		session.setAttribute("orderId", orderDetail.getOrderId());
		session.setAttribute("orderdate",orderDetail.getOrderDate());
		
		}
		
		return "Receipt";
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
