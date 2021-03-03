package com.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.pojo.Medicine;
import com.pojo.Order;
/**
 * This class implements MedicineDao and OrderDao interfaces 
 * and provides method implementation 
 * This class have jdbcTemplate, it is injected by pharmacyDaoImpl bean from config file 
 * @author priyankaku
 *
 */
public class PharmacyDaoImpl implements MedicineDao, OrderDao {

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
	 * @param medicine This Method takes medicine insert it in medicine Table and
	 *                 returns one if inserted
	 */
	public int insertMedicine(Medicine medicine) {
		String query = "insert into medicine(medicineId,medicineName,brand,price,medicineCategory,quantity) values(?,?,?,?,?,?)";
		int r = this.jdbcTemplate.update(query, medicine.getMedicineId(), medicine.getMedicineName(),
				medicine.getBrand(), medicine.getPrice(), medicine.getMedicineCategory(), medicine.getQuantity());
		return r;
	}

	/**
	 * @param medicine This Method takes medicine and update it in medicine Table
	 *                 and returns one if updated
	 */
	public int updateMedicine(Medicine medicine) {
		String query = "update medicine set  price=?, quantity=? where medicineId=?";
		int r = this.jdbcTemplate.update(query,  medicine.getPrice(), medicine.getQuantity(), medicine.getMedicineId());
		return r;
	}

	/**
	 * @param medicineId This Method takes medicineId and delete from medicine Table
	 *                   and returns one if deleted
	 */
	public int deleteMedicine(int medicineId) {
		String query = "delete from medicine where medicineId=?";
		int r = this.jdbcTemplate.update(query, medicineId);
		return r;
	}

	/**
	 * @param medicineId This Method takes medicineId and get that ID's Medicine from table using 
	 * rowMapper and returns medicine if found
	 */
	public Medicine getMedicine(int medicineId) {
		String query = "select * from medicine where medicineId=?";
		RowMapper<Medicine> rowMapper = new RowMapperImplMedicine();
		Medicine medicine = (Medicine) this.jdbcTemplate.queryForObject(query, rowMapper, medicineId);
		return medicine;
	}
    /**
     * This method is used to get All medicine List 
     */
	public List<Medicine> getAllMedicines() {
		String query = "select * from medicine";
		List<Medicine> medicines = this.jdbcTemplate.query(query, new RowMapperImplMedicine());
		return medicines;
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

	public void addOrderedMedicine(Order order, String brand, float price, String category) {

		if (order.getOrderStatus() == "completed") {

			Medicine medicine = new Medicine();
			medicine.setMedicineId(order.getOrderId());
			medicine.setMedicineName(order.getMedicineName());
			medicine.setBrand(brand);
			medicine.setMedicineCategory(category);
			medicine.setQuantity(order.getQuantity());
			medicine.setPrice(price);
			insertMedicine(medicine);
		}

	}

	public Medicine searchMedicineByName(String Name) {
	
		String query = "select * from medicine where medicineName=?";
		RowMapper<Medicine> rowMapper = new RowMapperImplMedicine();
		Medicine medicine = (Medicine) this.jdbcTemplate.queryForObject(query, rowMapper, Name);
		return medicine;

	}

	public Medicine searchMedicineByBrand(String brand) {
	
		String query = "select * from medicine where brand=?";
		RowMapper<Medicine> rowMapper = new RowMapperImplMedicine();
		Medicine medicine = (Medicine) this.jdbcTemplate.queryForObject(query, rowMapper, brand);
		return medicine;

	}

	public void raiseRequestIfOutOfStock() throws NumberFormatException, IOException {
		String query = "select * from medicine where quantity=0";
		RowMapper<Medicine> rowMapper = new RowMapperImplMedicine();
		Medicine medicine = (Medicine) this.jdbcTemplate.queryForObject(query, rowMapper);
		if(medicine!=null) {
		   System.out.println("This Medicine is Out Off Stock : "+medicine);
			Order order=new Order();
			order.setOrderDetails();
			insertOrder( order);
			System.out.println("Order is rasied for medicine "+medicine.getMedicineName());
		}
	
	}
	
}
