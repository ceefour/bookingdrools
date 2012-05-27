package com.sample;

/**
 * @author ceefour
 *
 */
public class BookProduct extends ProductRequest {

	private Status status = Status.NEW;
	
	public enum Status {
		NEW,
		BOOKED,
		OUT_OF_STOCK,
		NO_STOCK_DATA,
		INVALID
	}

	public BookProduct(String personId, String productId, Double qty) {
		super(personId, productId, qty);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookProduct [status=" + status + ", personId="
				+ getPersonId() + ", productId=" + getProductId()
				+ ", qty=" + getQty() + "]";
	}

}	
