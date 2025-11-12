package src.Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.Enumeration.OrderStatus;
import src.Enumeration.OrderType;

public class Order {
	public static int orderCount = 0;
	private int orderId;
	private List<OrderItem> orderItems;
	private User customer;
	private OrderType orderType;
	private OrderStatus orderStatus;
	private LocalDate CreatedAt;

	public Order(User customer, OrderType orderType) {
		this.customer = customer;
		this.orderId = orderCount;
		orderCount++;
		this.orderType = orderType;
		this.orderItems = new ArrayList<>();
		this.orderStatus = OrderStatus.PENDING;
		this.CreatedAt = LocalDate.now();
	}

	public void addItem(OrderItem item) {
		this.orderItems.add(item);
	}

	public void removeItem(OrderItem item) {
		this.orderItems.remove(item);
	}

	public List<OrderItem> getItems() {
		return orderItems;
	}

	public void updateStatus(OrderStatus newStatus) {
		this.orderStatus = newStatus;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public LocalDate getCreatedAt() {
		return this.CreatedAt;
	}

	public User getCustomer() {
		return this.customer;
	}

}
