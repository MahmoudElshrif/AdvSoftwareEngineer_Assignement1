package src.Classes;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private String name;
	private List<MenuItem> menuItems;
	private List<Addon> addons;

	public Menu(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
		List<Addon> addons = new ArrayList<>();
		addons.add(new Addon("Fries", 1));
		addons.add(new Addon("Sauce", 0.2));
		addons.add(new Addon("Katchup", 0.24));
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
