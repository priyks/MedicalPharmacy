package com.pojo;

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
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", brand=" + brand + ", price="
				+ price + ", medicineCategory=" + medicineCategory + ", quantity=" + quantity + "]";
	}
}
