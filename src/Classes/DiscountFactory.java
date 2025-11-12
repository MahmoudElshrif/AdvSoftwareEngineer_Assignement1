package src.Classes;

import src.Classes.DiscountStrategies.*;
import src.Interfaces.DiscountStrategy;

public class DiscountFactory {
	public static DiscountStrategy getStrategy(MenuItem item) {
		switch (item.getCategory().toLowerCase()) {
			case "chiken":
				return new NoDiscount();
			case "meat":
				return new MeatDiscount();
			case "pizza":
				return new PizzaDiscount();
			default:
				return new NoDiscount();
		}
	}
}
