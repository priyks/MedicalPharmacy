package com.dao;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.pojo.Medicine;
import com.pojo.Order;

public class OrderDaoImpl implements OrderDao {
	private JdbcTemplate jdbcTemplate;

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @param order
	 * 
	 */
	public int insertOrder(Order order) {
		String query = "insert into ordermedicine(orderId,medicineName,quantity) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, order.getOrderId(), order.getMedicineName(), order.getQuantity());
		return r;
	}

	public int updateOrder(Order order) {
		String query = "update ordermedicine set medicineName=? , quantity=? where orderId=?";
		int r = this.jdbcTemplate.update(query, order.getMedicineName(), order.getQuantity(), order.getOrderId());
		return r;
	}

	public int updateOrderStatus(Order order) {
		String query = "update ordermedicine set orderStatus='completed' where orderId=? and orderStatus='pending'";
		int r = this.jdbcTemplate.update(query, order.getOrderId());
		return r;
	}

	public int deleteOrder(int orderId) {
		String query = "delete from ordermedicine where orderId=?";
		int r = this.jdbcTemplate.update(query, orderId);
		return r;
	}

	public Order getOrder(int orderId) {
		String query = "select * from ordermedicine where orderId=?";
		RowMapper<Order> rowMapper = new RowMapperImplOrder();
		Order order = (Order) this.jdbcTemplate.queryForObject(query, rowMapper, orderId);
		return order;
	}

	public List<Order> getAllOrders() {
		String query = "select * from ordermedicine";
		List<Order> orders = this.jdbcTemplate.query(query, new RowMapperImplOrder());
		return orders;
	}

	public List<Order> getPendingOrders(Order order) {
		String query = "select * from ordermedicine where orderStatus='pending'";
		List<Order> pendingOrders = this.jdbcTemplate.query(query, new RowMapperImplOrder());
		return pendingOrders;
	}

	public void raiseRequestIfOutOfStock() throws NumberFormatException, IOException {
		String query = "select * from medicine where quantity=0";
		RowMapper<Medicine> rowMapper = new RowMapperImplMedicine();
		Medicine medicine = (Medicine) this.jdbcTemplate.queryForObject(query, rowMapper);
		if (medicine != null) {
			System.out.println("This Medicine is Out Off Stock : " + medicine);
			Order order = new Order();
			order.setOrderDetails();
			insertOrder(order);
			System.out.println("Order is rasied for medicine " + medicine.getMedicineName());
		}

	}

}
