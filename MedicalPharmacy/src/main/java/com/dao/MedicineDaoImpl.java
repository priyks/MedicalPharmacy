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
 * This class have jdbcTemplate, it is injected by MedicineDaoImpl bean from config file 
 * @author priyankaku
 *
 */
public class MedicineDaoImpl implements MedicineDao  {

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


	
}
