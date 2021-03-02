package com.dao;

import java.io.IOException;
import java.util.List;

import com.pojo.Order;


public interface OrderDao {

	public int insertOrder(Order order);
	public int updateOrder(Order order);
	public int updateOrderStatus(Order order);
	public int deleteOrder(int orderId);
	public Order getOrder(int orderId);
	public List<Order> getAllOrders();
	public List<Order> getPendingOrders(Order order);
	public void raiseRequestIfOutOfStock() throws NumberFormatException, IOException;
}
