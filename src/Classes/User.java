package src.Classes;

import java.util.List;
import java.util.ArrayList;

public class User {
	private String userName;
	private String phone;
	private List<Order> orders;

	public User(String userName, String phone) {
		this.userName = userName;
		this.phone = phone;
		this.orders = new ArrayList<>();
	}

	public void addOrder(Order newOrder) {
		this.orders.add(newOrder);
	}

	public String getPhone() {
		return this.phone;
	}

	public List<Order> getOrders() {
		return this.orders;
	}
}
