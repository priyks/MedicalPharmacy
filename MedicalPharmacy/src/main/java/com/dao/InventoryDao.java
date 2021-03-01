package com.dao;

import java.util.List;

import com.pojo.Inventory;


public interface InventoryDao {

	public int insert(Inventory inventory);
	public int update(Inventory inventory);
	public int delete(int inventoryId);
	public Inventory getInVentory(int inventoryId);
	public List<Inventory> getAllInventory();

}
