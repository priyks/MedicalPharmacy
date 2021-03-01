package com.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.dao.PharmacyDaoImpl;
import com.pojo.Doctor;
import com.pojo.Medicine;
import com.pojo.Order;
import com.pojo.Pharmacy;

public class ServiceController implements PharmacyService {
	
	PharmacyDaoImpl pharmacyDaoImpl;
	
	/**
	 * @return the pharmacyDaoImpl
	 */
	public PharmacyDaoImpl getPharmacyDaoImpl() {
		return pharmacyDaoImpl;
	}

	public void setPharmacyDaoImpl(PharmacyDaoImpl pharmacyDaoImpl) {
		this.pharmacyDaoImpl = pharmacyDaoImpl;
	}

	public void checkStock(Medicine medicine) {
	
		pharmacyDaoImpl.getAllMedicines();
		
	}

	public List<Order> pendingOrder(Order order) {
		
		List<Order> pendingOrders=pharmacyDaoImpl.getPendingOrders(order);
		return pendingOrders;
	}

	public void orderStock(Order order) {
	
		pharmacyDaoImpl.insertOrder(order);
	}

	public boolean searchDrByFristName(String firstName) {
	 
		
		return false;
	}

	public boolean searchDrByLastName(String lastName) {
	
		
		return false;
	}

	public List<Doctor> getDrList(Pharmacy pharmacy) {
		
		return null;
	}

	public boolean searchMedicineByName(Medicine medicine) {
		
		return false;
	}

	public boolean searchMedicineByBrand(Medicine medicine) {
		
		return false;
	}

	public List<Medicine> getAvaliableStock(Medicine medicine) {
		
		return null;
	}

}
