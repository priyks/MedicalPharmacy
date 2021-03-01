package com.service;

import java.util.List;

import com.pojo.Doctor;
import com.pojo.Inventory;
import com.pojo.OrderStock;
import com.pojo.Pharmacy;
import com.pojo.Stock;
import com.pojo.Supplier;

public interface PharmacyService {
	
	public void checkStock(Inventory inventory);
	public List<OrderStock> pendingOrder(OrderStock orderStock); 
	public void orderStock(Stock stock,Supplier supplier);
	public boolean searchDrByFristName(Pharmacy pharmacy);
	public boolean searchDrByLastName(Pharmacy pharmacy);
	public List<Doctor> getDrList(Pharmacy pharmacy);
	public boolean searchMedicineByName(Inventory inventory);
	public boolean searchMedicineByBrand(Inventory inventory );
	public List<Stock> getAvaliableStock(Inventory inventory);

}
