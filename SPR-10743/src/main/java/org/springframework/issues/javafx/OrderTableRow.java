package org.springframework.issues.javafx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import org.springframework.issues.pojos.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderTableRow {
	private IntegerProperty orderId;
	private IntegerProperty customerId;
	private IntegerProperty products;
	private BooleanProperty delivered;
	private IntegerProperty deliveryDays;
	private IntegerProperty total;

	public OrderTableRow() {
		orderId = new SimpleIntegerProperty();
		customerId = new SimpleIntegerProperty();
		products = new SimpleIntegerProperty();
		delivered = new SimpleBooleanProperty();
		deliveryDays = new SimpleIntegerProperty();
		total = new SimpleIntegerProperty();
	}

	public OrderTableRow(int orderId, int customerId, int products, boolean delivered, int deliveryDays, int total) {
		super();
		this.orderId = new SimpleIntegerProperty(orderId);
		this.customerId = new SimpleIntegerProperty(customerId);
		this.products = new SimpleIntegerProperty(products);
		this.delivered = new SimpleBooleanProperty(delivered);
		this.deliveryDays = new SimpleIntegerProperty(deliveryDays);
		this.total = new SimpleIntegerProperty(total);
	}

	public OrderTableRow(Order order) {
		this(order.getOrderId(), order.getCustomerId(), order.getProducts(), order.getDelivered(), order
				.getDeliveryDays(), order.getTotal());
	}

	public int getOrderId() {
		return orderId.get();
	}

	public int getCustomerId() {
		return customerId.get();
	}

	public int getProducts() {
		return products.get();
	}

	public boolean getDelivered() {
		return delivered.get();
	}

	public int getDeliveryDays() {
		return deliveryDays.get();
	}

	public int getTotal() {
		return total.get();
	}

	public void setOrderId(int orderId) {
		this.orderId.set(orderId);
	}

	public void setCustomerId(int customerId) {
		this.customerId.set(customerId);
	}

	public void setProducts(int products) {
		this.products.set(products);
	}

	public void setDelivered(boolean delivered) {
		this.delivered.set(delivered);
	}

	public void setDeliveryDays(int deliveryDays) {
		this.deliveryDays.set(deliveryDays);
	}

	public void setTotal(int total) {
		this.total.set(total);
	}

	public IntegerProperty orderIdProperty() {
		return orderId;
	}

	public IntegerProperty customerIdProperty() {
		return customerId;
	}

	public IntegerProperty productsProperty() {
		return products;
	}

	public BooleanProperty deliveredProperty() {
		return delivered;
	}

	public IntegerProperty deliveryDaysProperty() {
		return deliveryDays;
	}

	public IntegerProperty totalProperty() {
		return total;
	}
}
