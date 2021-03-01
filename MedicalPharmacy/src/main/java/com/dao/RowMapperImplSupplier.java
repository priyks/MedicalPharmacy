package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pojo.Supplier;

public class RowMapperImplSupplier implements RowMapper<Supplier>{

	public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {
		Supplier supplier=new Supplier();
		supplier.setSupplierId(rs.getInt(1));
		supplier.setSupplierName(rs.getString(2));
		supplier.setContactNo(rs.getString(3));
		supplier.setEmailId(rs.getString(4));
		supplier.setAddress(rs.getString(5));
		
		return supplier;
	}

}
