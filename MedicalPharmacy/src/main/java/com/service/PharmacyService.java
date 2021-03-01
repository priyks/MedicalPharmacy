package com.service;

import java.util.List;

import com.pojo.Doctor;
import com.pojo.Medicine;
import com.pojo.Order;
import com.pojo.Pharmacy;


public interface PharmacyService {
	
	public void checkStock(Medicine medicine);
	public List<Order> pendingOrder(Order order); 
	public void orderStock(Order order);
	public boolean searchDrByFristName(String firstName);
	public boolean searchDrByLastName(String LastName);
	public List<Doctor> getDrList(Pharmacy pharmacy);
	public boolean searchMedicineByName(Medicine medicine);
	public boolean searchMedicineByBrand(Medicine medicine);
	public List<Medicine> getAvaliableStock(Medicine medicine);

}
