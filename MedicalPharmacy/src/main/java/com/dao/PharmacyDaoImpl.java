package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.pojo.Medicine;
import com.pojo.Supplier;


@Component("pharmacyDaoImpl")
public class PharmacyDaoImpl implements SupplierDao,MedicineDao {

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

	public int insertSupplier(Supplier supplier) {
		String query = "insert into supplier(supplierId,supplierName,contactNo,emailId,address) values(?,?,?,?,?)";
		int r = this.jdbcTemplate.update(query, supplier.getSupplierId(), supplier.getSupplierName(),
				supplier.getContactNo(), supplier.getEmailId(), supplier.getAddress());
		return r;

	}

	public int updateSupplier(Supplier supplier) {
		String query = "update supplier set supplierName=? , contactNo=?, emailId=?, address=? where supplierId=?";
		int r = this.jdbcTemplate.update(query, supplier.getSupplierName(), supplier.getContactNo(),
				supplier.getEmailId(), supplier.getAddress(),supplier.getSupplierId());
		return r;

	}

	public int deleteSupplier(int SupplierId) {
		String query="delete from student where sid=?";
		int r=this.jdbcTemplate.update(query,SupplierId);
			return r;
	}

	public Supplier getSupplier(int supplierId) {
		 String query="select * from supplier where supplierId=?";
		 RowMapper<Supplier> rowMapper=new RowMapperImplSupplier();
		 Supplier supplier=(Supplier) this.jdbcTemplate.queryForObject(query, rowMapper,supplierId ); 
		 return supplier;
	}

	public List<Supplier> getAllSuppliers() {
		 String query="select * from supplier";
		 List<Supplier> suppliers=this.jdbcTemplate.query(query,new  RowMapperImplSupplier());
		return  suppliers;
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
