package src.Classes;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private String name;
	private List<MenuItem> menuItems;
	private List<Addon> addons;

	public Menu(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
		this.addons = new ArrayList<>();
		this.addons.add(new Addon("Fries", 1));
		this.addons.add(new Addon("Sauce", 0.2));
		this.addons.add(new Addon("Katchup", 0.24));
	}

	public List<Addon> getAddons() {
		return this.addons;
	}

	public List<MenuItem> getItems() {
		return this.menuItems;
	}

	public void displayMenu() {
		for (MenuItem i : menuItems) {
			System.out.println(i.getDetails());
		}
	}
}
