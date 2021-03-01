package com.pojo;

import java.util.List;

public class Inventory {
	private int inventoryId;
    private List<Stock> inStock;
    private List<Stock> outStock;
    private List<Stock> stockAvaliable;
	/**
	 * @return the inventoryId
	 */
	public int getInventoryId() {
		return inventoryId;
	}
	/**
	 * @param inventoryId the inventoryId to set
	 */
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	/**
	 * @return the inStock
	 */
	public List<Stock> getInStock() {
		return inStock;
	}
	/**
	 * @param inStock the inStock to set
	 */
	public void setInStock(List<Stock> inStock) {
		this.inStock = inStock;
	}
	/**
	 * @return the outStock
	 */
	public List<Stock> getOutStock() {
		return outStock;
	}
	/**
	 * @param outStock the outStock to set
	 */
	public void setOutStock(List<Stock> outStock) {
		this.outStock = outStock;
	}
	/**
	 * @return the stockAvaliable
	 */
	public List<Stock> getStockAvaliable() {
		return stockAvaliable;
	}
	/**
	 * @param stockAvaliable the stockAvaliable to set
	 */
	public void setStockAvaliable(List<Stock> stockAvaliable) {
		this.stockAvaliable = stockAvaliable;
	}
    
    
    
    
    
    

}
