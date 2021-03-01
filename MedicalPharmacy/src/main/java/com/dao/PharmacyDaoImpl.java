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
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteMedicine(int medicineId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Medicine getMedicine(int medicineId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Medicine> getAllMedicines() {
		// TODO Auto-generated method stub
		return null;
	}

}
