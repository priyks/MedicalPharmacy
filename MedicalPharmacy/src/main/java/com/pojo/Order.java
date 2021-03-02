package com.pojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Order {
	private int orderId;
	private  String medicineName;
	private String orderStatus;
	private int quantity;
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
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

	@Override
	public String toString() {
		return "[orderId=" + orderId + ", medicineName=" + medicineName + ", orderStatus=" + orderStatus
				+ ", quantity=" + quantity + "]";
	}
	
	public void setOrderDetails() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Order Id :");
		int id=Integer.parseInt(br.readLine());
		System.out.println("Enter Medicine Name :");
		String name=br.readLine();
		setMedicineName(name);
		System.out.println("Enter Order quantity");
		int quantity=Integer.parseInt(br.readLine());
		setQuantity(quantity);
		
	}
	
	
}
