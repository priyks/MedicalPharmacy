package com.dao;

import java.util.List;

import com.pojo.Supplier;

public interface SupplierDao {

	public int insertSupplier(Supplier supplier);
	public int updateSupplier(Supplier supplier);
	public int deleteSupplier(int Supplier);
	public Supplier getSupplier(int SupplierId);
	public List<Supplier> getAllSuppliers();
}
