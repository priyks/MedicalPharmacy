package com.service;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.MedicineDaoImpl;
import com.dao.OrderDaoImpl;
import com.pojo.Doctor;
import com.pojo.Medicine;
import com.pojo.Order;
import com.pojo.Pharmacy;

/**
 * 
 * This class is used to implement all services of PharmacyService Interface,
 * and also invoke application context , its required to set MedicineDaoImpl ref
 * to invoke dao related functionality
 * 
 * @author priyankaku
 *
 */
public class ServiceController implements PharmacyService {

	private MedicineDaoImpl medicineImpl;
	private OrderDaoImpl orderImpl;
	private Pharmacy pharmacy = null;

	/**
	 * @return the orderImpl
	 */
	public OrderDaoImpl getOrderImpl() {
		return orderImpl;
	}

	/**
	 * @param orderImpl the orderImpl to set
	 */
	public void setOrderImpl(OrderDaoImpl orderImpl) {
		this.orderImpl = orderImpl;
	}

	/**
	 * @return the pharmacy
	 */
	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	/**
	 * @param pharmacy the pharmacy to set
	 */
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	/**
	 * @return the medicineImpl
	 */
	public MedicineDaoImpl getMedicineImpl() {
		return medicineImpl;
	}

	/**
	 * @param medicineImpl the medicineImpl to set
	 */
	public void setMedicineImpl(MedicineDaoImpl medicineImpl) {
		this.medicineImpl = medicineImpl;
	}

	/**
	 * @return List of All pending Orders
	 */
	public List<Order> pendingOrder(Order order) {
		List<Order> pendingOrders = orderImpl.getPendingOrders(order);
		return pendingOrders;
	}

	/**
	 * @param Order This Method orders a stock which call insertOrder with Order on
	 *              MedicineDaoImpl
	 */
	public void orderStock(Order order) {

		orderImpl.insertOrder(order);
	}

	/**
	 * @param firstName This method will search Doctor by first Name if found print
	 *                  Doctor details and return true
	 */
	public boolean searchDrByFristName(String firstName) {
		for (Doctor dr : pharmacy.getDoctorList()) {
			if (dr.getFirstName().equals(firstName)) {
				System.out.println(" Doctor found first Name : " + dr.getFirstName());
				return true;
			}
		}
		return false;
	}

	/**
	 * @param LastName This method will search Doctor by Last Name if found print
	 *                 Doctor details and return true
	 */
	public boolean searchDrByLastName(String lastName) {
		for (Doctor dr : pharmacy.getDoctorList()) {
			if (dr.getLastName().equals(lastName)) {
				System.out.println(" Doctor found Last Name : " + dr.getLastName());
				return true;
			}
		}
		return false;
	}

	/**
	 * @param pharmacy this method takes pharmacy as parameter and returns Doctor
	 *                 List
	 */
	public List<Doctor> getDrList(Pharmacy pharmacy) {
		return pharmacy.getDoctorList();
	}

	/**
	 * @param medicineName This method Takes Medicine name and search it if matching
	 *                     name found
	 */
	public boolean searchMedicineByName(String medicineName) {
		if (medicineImpl.searchMedicineByName(medicineName) != null) {
			Medicine medicine = medicineImpl.searchMedicineByName(medicineName);
			System.out.println(medicine);
			System.out.println("Medicine is avaliable ...");
			return true;
		} else {
			System.out.println("Medicine is not avaliable...");
			return false;
		}
	}

	/**
	 * @param brand This method Takes Medicine brand and search it if matching name
	 *              found
	 */
	public boolean searchMedicineByBrand(String medicineBrand) {

		if (medicineImpl.searchMedicineByBrand(medicineBrand) != null) {
			Medicine medicine = medicineImpl.searchMedicineByBrand(medicineBrand);
			System.out.println(medicine);
			System.out.println("Medicine is avaliable ...");
			return true;
		} else {
			System.out.println("Medicine is not avaliable...");
			return false;
		}
	}

	/**
	 * @param medicine This method gets all the Medicine records in the table
	 */
	public void getAvaliableStock(Medicine medicine) {

		medicineImpl.getAllMedicines();
	}

	/**
	 * 
	 * @return This method gets the ApplicationContext using
	 *         {@link ClassPathXmlApplicationContext} which takes Config file
	 */
	public ApplicationContext getApplicationContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/resource/Pharma-Config.xml");
		return context;
	}

	/**
	 * this method displays Pharmacy Details
	 */
	public void getPharmacyDetails() {
		System.out.println("Pharamacy Name : " + pharmacy.getName() + "\nContact No : " + pharmacy.getContactNo()
				+ "\nLicence no : " + pharmacy.getLicenceNo() + "\nAddress :" + pharmacy.getAddress());

	}
}
