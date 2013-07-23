package org.springframework.issues.pojos;


public class Order {

	private int orderId;
	private int customerId;
	private int products;
	private boolean delivered;
	private int deliveryDays;
	private int total;
	
	public Order() {
	}

	public Order(int orderId, int customerId, int products,
			boolean delivered, int deliveryDays, int total) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.products = products;
		this.delivered = delivered;
		this.deliveryDays = deliveryDays;
		this.total = total;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getProducts() {
		return products;
	}

	public boolean getDelivered() {
		return delivered;
	}

	public int getDeliveryDays() {
		return deliveryDays;
	}

	public int getTotal() {
		return total;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setProducts(int products) {
		this.products = products;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public void setDeliveryDays(int deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
