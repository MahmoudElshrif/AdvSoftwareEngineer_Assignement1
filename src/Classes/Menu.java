package src.Classes;

import java.util.List;

public class Menu {
	private List<MenuItem> menuItems;

	public List<MenuItem> getItems() {
		return this.menuItems;
	}

	public void displayMenu() {
		for (MenuItem i : menuItems) {
			System.out.println(i.getDetails());
		}
	}
}
