package com.pharma.MedicalPharmacy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.PharmacyDaoImpl;
import com.pojo.Medicine;
import com.pojo.Pharmacy;



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
		
		PharmacyDaoImpl dao = context.getBean("pharmacyDaoImpl", PharmacyDaoImpl.class);
		System.out.println("Supplier " + dao);
		
		Medicine newMedicine=new Medicine();
		
	/*//insert medicine
		
		newMedicine.setMedicineId(5);
		newMedicine.setMedicineName("Gabapentin");
		newMedicine.setBrand("Rybelsus");
		newMedicine.setPrice(15);
		newMedicine.setMedicineCategory("Tablet");
		newMedicine.setQuantity(70);
		int result=dao.insertMedicine(newMedicine);
		System.out.println("Medicine Added...");*/
		
		
		/*// update Medicine
		newMedicine.setMedicineName("Vicks inhaler");
		newMedicine.setBrand("Vicks");
		newMedicine.setPrice(40);
		newMedicine.setMedicineCategory("Inhaler");
		newMedicine.setQuantity(50);
		newMedicine.setMedicineId(1);
		int updateResult=dao.updateMedicine(newMedicine);
		
		System.out.println("medicine Updated ...");*/
		
	/*	System.out.println("Single Medicine by Id");
		Medicine medi = dao.getMedicine(1);
		System.out.println(medi);
		
		System.out.println("List of Medicines ");
		
		List<Medicine> listOfMedicine = dao.getAllMedicines();
		for (Medicine medicines : listOfMedicine) {
			System.out.println(medicines);
		}*/
		
		
		

	}
}
