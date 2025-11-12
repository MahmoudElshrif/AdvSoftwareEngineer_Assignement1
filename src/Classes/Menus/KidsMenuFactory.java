package src.Classes.Menus;

import java.util.ArrayList;
import java.util.List;

import src.Classes.Addon;
import src.Classes.Menu;
import src.Classes.MenuItem;
import src.Interfaces.MenuFactory;

public class KidsMenuFactory implements MenuFactory {

	@Override
	public Menu getMenu() {
		List<MenuItem> items = new ArrayList<>();

		items.add(new MenuItem("Small Burger", 2, "meat"));
		items.add(new MenuItem("Soda", 3, "soda"));
		items.add(new MenuItem("Salad", 1, "meat"));
		return new Menu(items);
	}

}
