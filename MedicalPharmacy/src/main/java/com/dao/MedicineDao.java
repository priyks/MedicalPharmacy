package com.dao;

import java.util.List;

import com.pojo.Medicine;
import com.pojo.Supplier;

public interface MedicineDao {

	public int insertMedicine(Medicine medicine);
	public int updateMedicine(Medicine medicine);
	public int deleteMedicine(int medicineId);
	public Medicine getMedicine(int medicineId);
	public List<Medicine> getAllMedicines();
}
