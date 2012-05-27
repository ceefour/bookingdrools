package com.sample;


/**
 * @author ceefour
 *
 */
public class ProductBooking {

	private String personId;
	private String productId;
	private Double qty;
	private Status status;
	
	public enum Status {
		OPEN,
		UNBOOKED,
		WAITING,
		/**
		 * Kabur.
		 */
		CANCELED,
		ORDERED,
		MISSED,
	}

	public ProductBooking(String personId, String productId, Double qty) {
		super();
		this.personId = personId;
		this.productId = productId;
		this.qty = qty;
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

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ProductBooking [personId=" + personId + ", productId="
				+ productId + ", qty=" + qty + ", status=" + status
				+ "]";
	}

}
