package interfaces;

public interface MenuFactory {
	Menu createMenu();

	MenuItem createMenuItem(String itemType);
}
