package src.Classes.DiscountStrategies;

import src.Interfaces.DiscountStrategy;

public class ChickenDiscount implements DiscountStrategy {

	@Override
	public double applyDiscount(double amount) {
		return amount * 0.8;
	}

}
