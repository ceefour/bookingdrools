/**
 * 
 */
package com.sample;

/**
 * @author ceefour
 *
 */
public abstract class ProductRequest {

	private String personId;
	private String productId;
	private Double qty;
	
	public ProductRequest(String personId, String productId, Double qty) {
		super();
		this.personId = personId;
		this.productId = productId;
		this.qty = qty;
	}
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	
}
