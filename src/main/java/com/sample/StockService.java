/**
 * 
 */
package com.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author ceefour
 *
 */
public class StockService {
	
	private static Map<String, Double> stockData = new HashMap<String, Double>();
	
	static {
		stockData.put("zibalabel_t01", 1.0);
		stockData.put("zibalabel_t02", 2.0);
		stockData.put("zibalabel_t03", 3.0);
		stockData.put("zibalabel_t04", 4.0);
		stockData.put("zibalabel_t05", 5.0);
		stockData.put("zibalabel_t05x", 5.9);
	}
	
	public void stockReport() {
		for (Entry<String, Double> row : stockData.entrySet()) {
			System.out.println(String.format("%4.1f %-20s", row.getValue(), row.getKey()));
		}
	}

	public Double getAvailableQtyByProductId(String productId) {
		//System.out.println("Stock " + productId + " = " + stockData.get(productId));
		return stockData.get(productId);
	}
	
	public void decrease(String productId, Double amount) {
		if (stockData.containsKey(productId)) {
			Double lastStock = stockData.get(productId);
			if (lastStock - amount >= 0) {
				Double currentStock = lastStock - amount;
				stockData.put(productId, currentStock);
				System.out.println(productId + " stock changed, last: " + lastStock + ", booked: " + amount + ", available: " + currentStock);
			} else {
				throw new RuntimeException("Cannot decrease " + productId + " stock by " + amount + ", current stock is only " + lastStock);
			}
		} else {
			throw new RuntimeException("Cannot decrease: Stock untuk " + productId + " tidak ada!");
		}
	}
	
	public void increase(String productId, Double amount) {
		if (stockData.containsKey(productId)) {
			stockData.put(productId, stockData.get(productId) + amount);
		} else {
			stockData.put(productId, amount);
		}
		System.out.println(productId + " qty is now " + amount);
	}
	
}
