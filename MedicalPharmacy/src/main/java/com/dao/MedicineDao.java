package com.dao;

import java.util.List;

import com.pojo.Medicine;
import com.pojo.Order;

/**
 * this Interface contains all the database related method declarations for
 * Medicine
 * 
 * @author priyankaku
 *
 */
public interface MedicineDao {

	public int insertMedicine(Medicine medicine); // inserts a medicine data in medicine table

	public int updateMedicine(Medicine medicine); // updates a medicine data in medicine table

	public int deleteMedicine(int medicineId); // delete medicine from medicine table

	public Medicine getMedicine(int medicineId); // returns specific id's medicine from table

	public List<Medicine> getAllMedicines(); // return List of all medicine

	public void addOrderedMedicine(Order order, String brand, float price, String category);

	// this method adds ordered medicine in medicine table if order status is completed
	
	public Medicine searchMedicineByName(String Name); // returns medicine of given name

	public Medicine searchMedicineByBrand(String brand); //return medicine of given brand 
}
