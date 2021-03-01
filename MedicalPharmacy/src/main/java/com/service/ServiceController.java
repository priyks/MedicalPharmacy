package com.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.dao.PharmacyDaoImpl;
import com.pojo.Doctor;
import com.pojo.Medicine;
import com.pojo.Order;
import com.pojo.Pharmacy;


public class ServiceController implements PharmacyService,ApplicationContextAware {
	
	private PharmacyDaoImpl pharmacyDaoImpl;
	private ApplicationContext context;
	Pharmacy pharmacy=context.getBean("pharmacy",Pharmacy.class);
	/**
	 * @return the pharmacyDaoImpl
	 */
	public PharmacyDaoImpl getPharmacyDaoImpl() {
		return pharmacyDaoImpl;
	}

	public void setPharmacyDaoImpl(PharmacyDaoImpl pharmacyDaoImpl) {
		this.pharmacyDaoImpl = pharmacyDaoImpl;
	}

	public List<Order> pendingOrder(Order order) {
		
		List<Order> pendingOrders=pharmacyDaoImpl.getPendingOrders(order);
		return pendingOrders;
	}

	public void orderStock(Order order) {
	
		pharmacyDaoImpl.insertOrder(order);
	}

	public boolean searchDrByFristName(String firstName) {
		for (Doctor dr : pharmacy.getDoctorList()) {
			if (dr.getFirstName().equals(firstName)) {
				System.out.println(" Doctor found first Name : "+dr.getFirstName());	
				return  true;
			}
		}
		return false;
	}

	public boolean searchDrByLastName(String lastName) {
		for (Doctor dr : pharmacy.getDoctorList()) {
			if (dr.getLastName().equals(lastName)) {
				System.out.println(" Doctor found Last Name : "+dr.getLastName());	
				return  true;
			}
		}
		return false;
	}

	public List<Doctor> getDrList(Pharmacy pharmacy) {
		
		return pharmacy.getDoctorList();
	}

	public boolean searchMedicineByName(String medicineName) {
		
		return false;
	}

	public boolean searchMedicineByBrand(String medicineBrand) {
		
		return false;
	}

	public void  getAvaliableStock(Medicine medicine) {
		
		pharmacyDaoImpl.getAllMedicines();
		 
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context=applicationContext;
		
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void getPharmacyDetails() {
		System.out.println("Pharamacy Name : "+pharmacy.getName()+"\nContact No : "+pharmacy.getContactNo()
		+"\nLicence no : "+pharmacy.getLicenceNo()+"\nAddress :"+pharmacy.getAddress());
		
		
	}

	
}
