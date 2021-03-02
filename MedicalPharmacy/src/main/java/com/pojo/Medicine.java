package com.pojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;


public class Medicine {
	private int medicineId;
	private String medicineName;
	private String brand;
	private float price;
	private String  medicineCategory;
	private int quantity;
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the medicineId
	 */
	public int getMedicineId() {
		return medicineId;
	}
	/**
	 * @param medicineId the medicineId to set
	 */
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	/**
	 * @return the medicineName
	 */
	public String getMedicineName() {
		return medicineName;
	}
	/**
	 * @param medicineName the medicineName to set
	 */
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}	
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the medicineCategory
	 */
	public String getMedicineCategory() {
		return medicineCategory;
	}
	/**
	 * @param medicineCategory the medicineCategory to set
	 */
	public void setMedicineCategory(String medicineCategory) {
		this.medicineCategory = medicineCategory;
	}

	@Override
	public String toString() {
		return "[medicineId=" + medicineId + ", medicineName=" + medicineName + ", brand=" + brand + ", price="
				+ price + ", medicineCategory=" + medicineCategory + ", quantity=" + quantity + "]";
	}
	
	public void setMedicineDetails() throws IOException {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Medicine Id :");
		int id=Integer.parseInt(br.readLine());
		setMedicineId(id);
		System.out.println("Enter Medicine Name :");
		String name=br.readLine();
		setMedicineName(name);
		System.out.println("Enter Medicine Brand :");
		String brand=br.readLine();
		setBrand(brand);
		System.out.println("Enter Medicine price :");
		float price=Float.parseFloat(br.readLine());
		setPrice(price);
		System.out.println("Enter Medicine Category :");
		String category=br.readLine();
		setMedicineCategory(category);
		System.out.println("Enter Medicine Qauntity :");
		int quantity=Integer.parseInt(br.readLine());
		setQuantity(quantity);
	}
}
