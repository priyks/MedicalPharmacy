package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.pojo.Order;

public class RowMapperImplOrder implements RowMapper<Order>{

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order=new Order();
		order.setOrderId(rs.getInt(1));
		order.setMedicineName(rs.getString(2));
		order.setOrderStatus(rs.getString(3));
		order.setQuantity(rs.getInt(4));
	
		return order;
	}

}
