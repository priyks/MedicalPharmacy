package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.pojo.Medicine;


public class RowMapperImplMedicine implements RowMapper<Medicine> {

	public Medicine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Medicine medicine=new Medicine();
		medicine.setMedicineId(rs.getInt(1));
		medicine.setMedicineName(rs.getString(2));
		medicine.setBrand(rs.getString(3));
		medicine.setPrice(rs.getFloat(4));
		medicine.setMedicineCategory(rs.getString(5));
		medicine.setQuantity(rs.getInt(6));
		return medicine;
	}
	
}
