package com.pharma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import com.dao.PharmacyDaoImpl;
import com.pojo.Doctor;
import com.pojo.Medicine;
import com.pojo.Order;
import com.pojo.Pharmacy;
import com.service.ServiceController;

public class App {
	public static void main(String[] args) throws IOException {
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("com/pharma/Pharma-Config.xml");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ServiceController controller = new ServiceController();
		ApplicationContext context = controller.getApplicationContext();
		Pharmacy pharmacy = context.getBean("pharmacy", Pharmacy.class);
		
		/*
		 * System.out.println(pharmacy); System.out.println(pharmacy.getDoctorList());
		 * Medicine medicine = context.getBean("medicine1", Medicine.class);
		 * System.out.println(medicine);
		 */

		PharmacyDaoImpl dao = context.getBean("pharmacyDaoImpl", PharmacyDaoImpl.class);
		System.out.println("Pharmacy " + dao);

		/*
		 * ServiceController controller=new ServiceController();
		 * controller.setApplicationContext(context);
		 * controller.setPharmacyDaoImpl(dao);
		 */

		/*
		 * // update Medicine newMedicine.setMedicineName("Vicks inhaler");
		 * newMedicine.setBrand("Vicks"); newMedicine.setPrice(40);
		 * newMedicine.setMedicineCategory("Inhaler"); newMedicine.setQuantity(50);
		 * newMedicine.setMedicineId(1); int
		 * updateResult=dao.updateMedicine(newMedicine);
		 * 
		 * System.out.println("medicine Updated ...");
		 */

		/*
		 * System.out.println("Single Medicine by Id"); Medicine medi =
		 * dao.getMedicine(1); System.out.println(medi);
		 * 
		 * System.out.println("List of Medicines ");
		 * 
		 * List<Medicine> listOfMedicine = dao.getAllMedicines(); for (Medicine
		 * medicines : listOfMedicine) { System.out.println(medicines); }
		 */

	     Order order = new Order();

		// insert order
		/*
		 * order.setOrderId(115); order.setMedicineName("Metformin");
		 * order.setQuantity(20);
		 * 
		 * 
		 * int result=dao.insertOrder(order);
		 * System.out.println("Request raised for Order.. "+result);
		 */

		// update order

		/*
		 * order.setMedicineName("Metform"); order.setQuantity(30);
		 * order.setOrderId(115); int updateResult=dao.updateOrder(order);
		 * System.out.println("order updated ...");
		 */

		// update order status to complete

		/*
		 * order.setOrderId(115); int res=dao.updateOrderStatus(order);
		 * System.out.println(" order status updated to complete ...");
		 */

		// delete order by order id
		/*
		 * dao.deleteOrder(113); System.out.println("order delete ...");
		 */

		// get specific order by id

		/*
		 * Order getOrder=dao.getOrder(112); System.out.println(getOrder);
		 */

		/*
		 * System.out.println("List of all pending orders"); List<Order>
		 * pendingOrders=dao.getPendingOrders(order); for(Order orders: pendingOrders) {
		 * System.out.println(orders); }
		 */

		// list of all orders
		/*
		 * System.out.println("List of All Orders : "); List<Order>
		 * allOrders=dao.getAllOrders(); for(Order allorder:allOrders) {
		 * System.out.println(allorder); }
		 */
		ServiceController dbService = context.getBean("serviceController", ServiceController.class);
		System.out.println(dbService);

		int i = 0;

		System.out.println("thanks for using our system :");

		do {

			System.out.println("-------------Medical Pharmacy System-----------------");
			System.out.println("Press 1 for Medicine :");
			System.out.println("Press 2 for Order :");
			System.out.println("Press 3 for Pharmacy Serives :");
			System.out.println("Press 4 for Exit :");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {

			case 1:

				System.out.println("press 1 to add Medicine :");
				System.out.println("Press 2 to update Medicine :");
				System.out.println("Press 3 to delete Medicine :");
				System.out.println("press 4 to get Specifice Medicine by Id :");
				System.out.println("Press 5 to get All Medicine :");
				System.out.println("Press 6 to break this switch :");
				int choiceMedicine = Integer.parseInt(br.readLine());
				Medicine newMedicine = new Medicine();
				switch (choiceMedicine) {

				case 1:
					// insert medicine
					newMedicine.setMedicineDetails();
					int result = dao.insertMedicine(newMedicine);
					System.out.println("Medicine Added..." + result);
					break;
				case 2:
					// update Medicine
					System.out.println("Enter Id :");
					int medId=Integer.parseInt(br.readLine());
					System.out.println("Enter price :");
					float medPrice=Float.parseFloat(br.readLine());
					System.out.println("Enter quantity :");
					int quantity=Integer.parseInt(br.readLine());
					newMedicine.setMedicineId(medId);
					newMedicine.setPrice(medPrice);
					newMedicine.setQuantity(quantity);
					int updateResult = dao.updateMedicine(newMedicine);
					System.out.println("medicine Updated ..."+updateResult);
					break;
				case 3:
					System.out.println("Enter Medicine Id to delete Medicine :");
					int id = Integer.parseInt(br.readLine());
					int deleteResult = dao.deleteMedicine(id);
					System.out.println("Medicine delete ..."+ deleteResult);
					break;
				case 4:
					System.out.println("Enter Id to get Medicine by Id ");
					int mid = Integer.parseInt(br.readLine());
					Medicine data = dao.getMedicine(mid);
					System.out.println(data);
					break;
				case 5:
					System.out.println(" All Available Medicine : ");
				    List<Medicine> listOfMedicine = dao.getAllMedicines(); 
				    for (Medicine medicines : listOfMedicine)
				    { System.out.println(medicines); }
					break;

				case 6:
					i = 6;
					break;

				}
			   break;	

			
			case 2:

				System.out.println("press 1 to add Order :");
				System.out.println("Press 2 to update Order:");
				System.out.println("Press 3 to delete Order :");
				System.out.println("press 4 to get Specifice Order by Id :");
				System.out.println("Press 5 to get All Order :");
				System.out.println("Press 6 to break this switch :");
				Order newOrder = new Order();
				int orderChoice = Integer.parseInt(br.readLine());
				switch (orderChoice) {

				case 1:
					newOrder.setOrderDetails();
					int result = dao.insertOrder(newOrder);
					System.out.println("Request raised for Order.. " + result);
					break;
				case 2:
					System.out.println("Enter Id :");
					int orId=Integer.parseInt(br.readLine());
					System.out.println("Enter Medicine Name :");
					String medName=br.readLine();
					System.out.println("Enter quantity :");
					int quantity=Integer.parseInt(br.readLine());
					newOrder.setOrderId(orId);
					newOrder.setMedicineName(medName);
					newOrder.setQuantity(quantity);
					int updateResult = dao.updateOrder(newOrder);
					System.out.println("order updated ..." + updateResult);
					break;
				case 3:
					System.out.println("Enter Order id to delete ...");
					int orderId = Integer.parseInt(br.readLine());
					dao.deleteOrder(orderId);
					System.out.println("order delete ...");
					break;
				case 4:
					System.out.println("Enter Order id to get Order :");
					int id = Integer.parseInt(br.readLine());
					Order getOrder = dao.getOrder(id);
					System.out.println(getOrder);
					break;
				case 5:
					System.out.println("List of All Orders : ");
					List<Order> allOrders = dao.getAllOrders();
					for (Order allorder : allOrders) {
						System.out.println(allorder);
					}
					break;
				case 6:
					i = 6;
					break;

				}
				
				System.out.println("----------------------------------");
				break;
				
			case 3:
				System.out.println("-----------------------------------------");
				System.out.println("Press 1 to get available Medicines :");
				System.out.println("Press 2 to search Medicine By Name :");
				System.out.println("Press 3 to search Medicine by Brand :");
				System.out.println("Press 4 to get List of Doctors :");
				System.out.println("Press 5 to Order a Medicine if its out off stock :");
				System.out.println("Press 6 to display all pending Orders : ");
				System.out.println("Press 7 to get all Pharmacy details :");
				System.out.println("Press 8 to break this switch :");
				int choice1 = Integer.parseInt(br.readLine());
				switch (choice1) {

				case 1:
					System.out.println(" All Available Medicine : ");
				    List<Medicine> listOfMedicine = dao.getAllMedicines(); 
				    for (Medicine medicines : listOfMedicine)
				    { System.out.println(medicines); }
					break;
				case 2:
					System.out.println("Enter Medicine Name :");
					String midName = br.readLine();
					Medicine midByName=dao.searchMedicineByName(midName);
					System.out.println(midByName);
					break;
				case 3:
					System.out.println("Enter Medicine Brand :");
					String midBrand = br.readLine();
					Medicine midByBrand=dao.searchMedicineByBrand(midBrand );
					System.out.println(midByBrand);
					break;
				case 4:
					System.out.println("Doctor List :");
					List<Doctor> drList = dbService.getDrList(pharmacy);
					for (Doctor dr : drList) {
						System.out.println(dr);
					}
					break;
				case 5:
					dao.raiseRequestIfOutOfStock();
					break;
				case 6:
					System.out.println("List of all pending orders");
					List<Order> pendingOrders = dao.getPendingOrders(order);
					for (Order orders : pendingOrders) {
						System.out.println(orders);
					}
					break;
				case 7:
					dbService.getPharmacyDetails();
					break;
				case 8:
					break;

				}
				
		         break;
			case 4:
				i=4;
				System.out.println("Thanks for using our system ...");
				break;

			}

		} while (i != 4);

	}
}
