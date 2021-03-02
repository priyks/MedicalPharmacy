package com.dao;

import java.util.List;

import com.pojo.Medicine;
import com.pojo.Order;

public interface MedicineDao {

	public int insertMedicine(Medicine medicine);
	public int updateMedicine(Medicine medicine);
	public int deleteMedicine(int medicineId);
	public Medicine getMedicine(int medicineId);
	public List<Medicine> getAllMedicines();
	public void addOrderedMedicine(Order order,String brand,float price,String category);
	public Medicine searchMedicineByName(String Name);
	public Medicine searchMedicineByBrand(String brand);
}
