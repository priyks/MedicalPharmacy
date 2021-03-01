package com.pharma.MedicalPharmacy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.PharmacyDaoImpl;
import com.pojo.Medicine;
import com.pojo.Order;
import com.pojo.Pharmacy;
import com.service.ServiceController;



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
		System.out.println("Pharmacy " + dao);
		
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
		
		Order order=new Order();
		
		//insert order 
	/*	order.setOrderId(115);
		order.setMedicineName("Metformin");
		order.setQuantity(20);
		
	
		int result=dao.insertOrder(order);
		System.out.println("Request raised for Order.. "+result);*/
		
		// update order
		
		/*order.setMedicineName("Metform");
		order.setQuantity(30);
		order.setOrderId(115);
		int updateResult=dao.updateOrder(order);
		System.out.println("order updated ...");*/
		
		// update order status to complete 
		
		/*order.setOrderId(115);
		int res=dao.updateOrderStatus(order);
		System.out.println(" order status updated to complete ...");
		*/
		
		// delete order by order id
		/*dao.deleteOrder(113);
		System.out.println("order delete ...");
		*/
		
		// get specific order by id
		
	  /* Order getOrder=dao.getOrder(112);	
	   System.out.println(getOrder);*/
		
		/*System.out.println("List of all pending orders");
		List<Order> pendingOrders=dao.getPendingOrders(order);
		for(Order orders: pendingOrders) {
			System.out.println(orders);
		}*/
		
		// list of all orders
	  /*System.out.println("List of All Orders : ");
		List<Order> allOrders=dao.getAllOrders();
		for(Order allorder:allOrders) {
			System.out.println(allorder);
		}*/
		
		ServiceController dbService=context.getBean("serviceController",ServiceController.class);
		System.out.println(dbService.getContext());
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
