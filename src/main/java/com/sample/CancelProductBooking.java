package com.sample;

public class CancelProductBooking extends ProductRequest {

	private Status status = Status.NEW;
	
	public enum Status {
		NEW,
		CANCELED,
		NOT_FOUND
	}

	public CancelProductBooking(String personId, String productId, Double qty) {
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
		return "CancelProductBooking [status=" + status + ", personId="
				+ getPersonId() + ", productId=" + getProductId()
				+ ", qty=" + getQty() + "]";
	}

}
