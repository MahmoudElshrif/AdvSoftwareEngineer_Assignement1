package src.Interfaces;

import src.Classes.Menu;
import src.Classes.MenuItem;

public interface MenuFactory {
	Menu createMenu();

	MenuItem createMenuItem(String itemType);
}
