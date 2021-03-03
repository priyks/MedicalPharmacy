package com.dao;

import java.io.IOException;
import java.util.List;

import com.pojo.Order;

/**
 * This Interface contains all the database related method declarations for
 * Order
 * 
 * @author priyankaku
 *
 */

public interface OrderDao {

	public int insertOrder(Order order); // inserts a order data in order medicine table and returns 1 if inserted 

	public int updateOrder(Order order); // update a order data in order medicine table and returns 1 if updated 

	public int updateOrderStatus(Order order); // update order status pending to completed and returns 1 if updated

	public int deleteOrder(int orderId); // delete a order by given orderId and returns 1 if deleted

	public Order getOrder(int orderId); // get order of specific id

	public List<Order> getAllOrders(); // returns list of all orders from order medicine table

	public List<Order> getPendingOrders(Order order); // return list of all orders which are pending

	public void raiseRequestIfOutOfStock() throws NumberFormatException, IOException;
	// raise an order request if quantity of medicine is 0
}
