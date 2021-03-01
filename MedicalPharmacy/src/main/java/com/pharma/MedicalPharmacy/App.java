package com.pharma.MedicalPharmacy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.PharmacyDaoImpl;
import com.pojo.Medicine;
import com.pojo.Pharmacy;
import com.pojo.Stock;
import com.pojo.Supplier;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/pharma/MedicalPharmacy/Pharma-Config.xml");
		Pharmacy pharmacy = context.getBean("pharmacy", Pharmacy.class);
		System.out.println(pharmacy);
		System.out.println(pharmacy.getDoctorList());
		Medicine medicine = context.getBean("medicine1", Medicine.class);
		System.out.println(medicine);
		Supplier supplier = context.getBean("supplier", Supplier.class);
		System.out.println(supplier);
		Stock stock = context.getBean("stock1", Stock.class);
		System.out.println(stock);
		PharmacyDaoImpl dao = context.getBean("pharmacyDaoImpl", PharmacyDaoImpl.class);
		System.out.println("Supplier " + dao);
		Supplier s = new Supplier();
		/*
		 // insert supplier 
		  s.setSupplierId(102); s.setSupplierName("Vinod kumar");
		  s.setContactNo("9766357093"); s.setEmailId("vinodkumar@gmail.com");
		  s.setAddress("Pune"); int r=dao.insertSupplier(s);
		  System.out.println("Supplier added...");*/
		 

		/*
		 // update supplier
		 * s.setSupplierId(101); s.setSupplierName("Amol pardeshi");
		 * s.setEmailId("amol.pardeshi@gmail.com"); s.setContactNo("9876563838");
		 * s.setAddress("Mumbai"); int r=dao.updateSupplier(s);
		 * System.out.println("Supplier updated...");
		 */

		// single record retrieval
		
		/*	System.out.println("Single Suppliers by Id");
		Supplier newSupplier = dao.getSupplier(101);
		System.out.println(newSupplier);
		
        // list of suppliers
		System.out.println("list of Suppliers");
		List<Supplier> listOfSupplier = dao.getAllSuppliers();
		for (Supplier suppliers : listOfSupplier) {
			System.out.println(suppliers);
		}*/
		
		
		
		

	}
}
