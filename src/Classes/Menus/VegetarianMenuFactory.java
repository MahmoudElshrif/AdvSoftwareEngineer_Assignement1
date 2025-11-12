package src.Classes.Menus;

import java.util.ArrayList;
import java.util.List;

import src.Classes.Menu;
import src.Classes.MenuItem;
import src.Interfaces.MenuFactory;

public class VegetarianMenuFactory implements MenuFactory {

	@Override
	public Menu getMenu() {
		List<MenuItem> items = new ArrayList<>();

		items.add(new MenuItem("Salad", 1, "sidedish"));
		items.add(new MenuItem("Soda", 3, "drink"));
		items.add(new MenuItem("Falafel", 4, "falafel"));
		items.add(new MenuItem("Water", 0.5, "drink"));

		return new Menu(items);
	}

}
