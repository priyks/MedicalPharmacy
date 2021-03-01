package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.pojo.Medicine;



@Component("pharmacyDaoImpl")
public class PharmacyDaoImpl implements MedicineDao {

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

}
