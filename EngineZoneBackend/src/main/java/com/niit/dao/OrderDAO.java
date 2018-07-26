package com.niit.dao;

import com.niit.model.OrderDetail;

public interface OrderDAO
{
	public boolean receiptGenerate(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String username);
}
