package src.Classes;

import java.util.List;

public class OrderItem {
	private MenuItem menuitem;
	private int quantity;
	private List<Addon> addons;
	private double itemTotal;

	public double calculateItemTotal() {
		double addOnsTotal = 0.0;
		for (Addon addOn : addons) {
			addOnsTotal += addOn.getPrice();
		}
		this.itemTotal = (menuitem.getPrice() + addOnsTotal) * quantity;
		return this.itemTotal;
	}

	public void incQuantity() {
		quantity++;
	}

	public List<Addon> getAddon() {
		return addons;
	}

	public void addAddon(Addon addon) {
		addons.add(addon);
	}

	public int getQuanitity() {
		return quantity;
	}

	public MenuItem getItem() {
		return menuitem;
	}
}
