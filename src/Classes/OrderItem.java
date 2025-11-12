package src.Classes;

import java.util.ArrayList;
import java.util.List;

import src.Interfaces.DiscountStrategy;

public class OrderItem {
	private MenuItem menuitem;
	private int quantity;
	private List<Addon> addons;

	public OrderItem(MenuItem menuitem) {
		this.menuitem = menuitem;
		this.quantity = 1;
		this.addons = new ArrayList<>();
	}

	public double calculateItemTotal() {
		DiscountStrategy disc = DiscountFactory.getStrategy(menuitem);
		double total = disc.applyDiscount(menuitem.getPrice());
		for (Addon addon : addons) {
			total += addon.getPrice();
		}
		total *= quantity;
		return total;
	}

	public void incQuantity() {
		quantity++;
	}

	public List<Addon> getAddons() {
		return addons;
	}

	public void addAddon(Addon addon) {
		addons.add(addon);
	}

	public int getQuantity() {
		return quantity;
	}

	public MenuItem getItem() {
		return menuitem;
	}
}
