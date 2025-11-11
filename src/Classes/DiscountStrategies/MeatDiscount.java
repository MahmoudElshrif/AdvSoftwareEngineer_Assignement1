package src.Classes.DiscountStrategies;

import src.Interfaces.DiscountStrategy;

public class MeatDiscount implements DiscountStrategy {

	@Override
	public double applyDiscount(double amount) {
		return amount * 0.95;
	}

}
