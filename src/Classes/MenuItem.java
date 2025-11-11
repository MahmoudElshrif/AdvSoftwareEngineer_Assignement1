package src.Classes;

import java.util.List;

public class MenuItem {
	private int itemId;
	private String itemName;
	private String description;
	private double price;
	private String category;
	private boolean isAvailable;
	private List<Addon> availableAddons;

	public String getDetails() {
		return "Item: " + itemName + "\nDescription: " + description + "\nPrice: $" + price + "\nCategory: " + category
				+ "\nAvailable: " + isAvailable;
	}

	public double getPrice() {
		return price;
	}
}
