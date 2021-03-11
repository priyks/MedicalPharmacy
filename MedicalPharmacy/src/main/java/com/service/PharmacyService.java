package com.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.pojo.Doctor;
import com.pojo.Medicine;
import com.pojo.Order;
import com.pojo.Pharmacy;


public interface PharmacyService {
	
	public List<Order> pendingOrder(Order order); 
	public void orderStock(Order order);
	public boolean searchDrByFristName(String firstName);
	public boolean searchDrByLastName(String LastName);
	public List<Doctor> getDrList(Pharmacy pharmacy);
	public boolean searchMedicineByName(String medicineName);
	public boolean searchMedicineByBrand(String medicineBrand);
	public void getAvaliableStock(Medicine medicine);
	public void getPharmacyDetails();
	public ApplicationContext getApplicationContext();

}
