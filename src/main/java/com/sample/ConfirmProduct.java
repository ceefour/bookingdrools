/**
 * 
 */
package com.sample;

/**
 * @author ceefour
 *
 */
public class ConfirmProduct extends ProductRequest {
	
	private boolean canWait;

	public ConfirmProduct(String personId, String productId, Double qty, boolean canWait) {
		super(personId, productId, qty);
		this.canWait = canWait;
	}

}
