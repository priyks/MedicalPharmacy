package com.pojo;


public class Order {
	private int orderId;
	private  String medicineName;
	private String orderStatus;
	private int qauntity;
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
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
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
	 * @return the qauntity
	 */
	public int getQauntity() {
		return qauntity;
	}
	/**
	 * @param qauntity the qauntity to set
	 */
	public void setQauntity(int qauntity) {
		this.qauntity = qauntity;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the medicine
	 */
	
}
