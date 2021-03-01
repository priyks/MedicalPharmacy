package com.dao;

import java.util.List;

import com.pojo.Stock;

public interface StockDao {
	public int insert(Stock stock);
	public int update(Stock stock);
	public int delete(int stockId);
	public Stock getStock(int StockId);
	public List<Stock> getAllStock();
}
