package src.Classes.Menus;

import java.util.ArrayList;
import java.util.List;

import src.Classes.Menu;
import src.Classes.MenuItem;
import src.Interfaces.MenuFactory;

public class NonVegetarianMenuFactory implements MenuFactory {
	@Override
	public Menu getMenu() {
		List<MenuItem> items = new ArrayList<>();

		items.add(new MenuItem("Burger", 5, "meat"));
		items.add(new MenuItem("Double Burger", 10, "meat"));
		items.add(new MenuItem("Soda", 3, "soda"));
		items.add(new MenuItem("Pizza", 10, "pizza"));
		items.add(new MenuItem("Chiken", 10, "chiken"));

		return new Menu(items);
	}

}
