package src.Classes;

public class MenuItem {
	private String itemName;
	private double price;
	private String category;

	public MenuItem(String itemName, double price, String category) {
		this.itemName = itemName;
		this.price = price;
		this.category = category;
	}

	public String getDetails() {
		return "Item: " + itemName + "\nPrice: $" + price + "\nCategory: " + category;
	}

	public String getName() {
		return itemName;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}
}
