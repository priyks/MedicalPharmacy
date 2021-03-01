package com.dao;

import java.util.List;

import com.pojo.Order;


public interface OrderDao {

	public int insertOrder(Order order);
	public int updateOrder(Order order);
	public void updateOrderStatus(String status);
	public int deleteOrder(int orderId);
	public Order getOrder(int orderId);
	public List<Order> getAllOrders();
	public List<Order> getPendingOrders(Order order);
}