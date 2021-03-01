package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.pojo.Medicine;
import com.pojo.Order;

@Component("pharmacyDaoImpl")
public class PharmacyDaoImpl implements MedicineDao,OrderDao {

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

	public int insertMedicine(Medicine medicine) {
		String query = "insert into medicine(medicineId,medicineName,brand,price,medicineCategory,quantity) values(?,?,?,?,?,?)";
		int r = this.jdbcTemplate.update(query, medicine.getMedicineId(),medicine.getMedicineName(),medicine.getBrand(),
				medicine.getPrice(),medicine.getMedicineCategory(),medicine.getQuantity());
		return r;
	}

	public int updateMedicine(Medicine medicine) {
		String query = "update medicine set medicineName=? , brand=?, price=?, medicineCategory=?, quantity=? where medicineId=?";
		int r = this.jdbcTemplate.update(query, medicine.getMedicineName(),medicine.getBrand(),
				medicine.getPrice(),medicine.getMedicineCategory(),medicine.getQuantity(),medicine.getMedicineId());
		return r;
	}

	public int deleteMedicine(int medicineId) {
		String query="delete from medicine where medicineId=?";
		int r=this.jdbcTemplate.update(query,medicineId);
			return r;
	}

	public Medicine getMedicine(int medicineId) {
		String query="select * from medicine where medicineId=?";
		 RowMapper<Medicine> rowMapper=new RowMapperImplMedicine();
		 Medicine medicine=(Medicine) this.jdbcTemplate.queryForObject(query, rowMapper,medicineId ); 
		 return medicine;
	}

	public List<Medicine> getAllMedicines() {
		 String query="select * from medicine";
		 List<Medicine> medicines=this.jdbcTemplate.query(query,new  RowMapperImplMedicine());
		return  medicines;
	}

	public int insertOrder(Order order) {
		String query = "insert into ordermedicine(orderId,medicineName,quantity) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,order.getOrderId(),order.getMedicineName(),order.getQuantity());
		return r;
	}

	public int updateOrder(Order order) {
		String query = "update ordermedicine set medicineName=? , quantity=? where orderId=?";
		int r = this.jdbcTemplate.update(query, order.getMedicineName(),order.getQuantity(),order.getOrderId());
		return r;
	}

	public int updateOrderStatus(Order order) {
		String query = "update ordermedicine set orderStatus='completed' where orderId=? and orderStatus='pending'";
		int r = this.jdbcTemplate.update(query,order.getOrderId());
	 return r;
	}

	public int deleteOrder(int orderId) {
		String query="delete from ordermedicine where orderId=?";
		int r=this.jdbcTemplate.update(query,orderId);
			return r;
	}

	public Order getOrder(int orderId) {
		String query="select * from ordermedicine where orderId=?";
		 RowMapper<Order> rowMapper=new RowMapperImplOrder();
		 Order order=(Order) this.jdbcTemplate.queryForObject(query, rowMapper,orderId); 
		 return order;
	}

	public List<Order> getAllOrders() {
		 String query="select * from ordermedicine";
		 List<Order> orders=this.jdbcTemplate.query(query,new  RowMapperImplOrder());
		return orders;
	}

	public List<Order> getPendingOrders(Order order) {
		String query= "select * from ordermedicine where orderStatus='pending'";
		List<Order> pendingOrders=this.jdbcTemplate.query(query, new RowMapperImplOrder());
		return pendingOrders;
	}

}
